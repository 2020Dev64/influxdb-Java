package com.abbeloosindustries.repository;

import com.abbeloosindustries.model.TemperatureSensor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.influxdb.query.internal.FluxResultMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InfluxDBRepository {

    private String dbName = "baeldung";
    private String bucket = "RoofGarden";
    private String organization = "1724611cb04f2363";
    private String url = "https://eu-central-1-1.aws.cloud2.influxdata.com";
    private char[] token = "QBrxpfv5SG4mWWGiUIUgCFdrF5S339z3pruMzTjvo1Oc6Ygakd9HJXA4dZcRRhHGFtlImpUYInn9plzqAg2ylg==".toCharArray();
    private List<TemperatureSensor> memoryPointList = new ArrayList<>();
    private String jsonStr = "";

    // connectDatabase() makes a connection with the influxDB on my computer
    private final InfluxDBClient connection = connectToCloudDatabase();

    public List getList(){
        // write a flux query
        String flux = "from(bucket:\"RoofGarden\") |> range(start: -7d)";
        QueryApi queryApi = connection.getQueryApi();
        List<FluxTable> tables = queryApi.query(flux, organization);
        // Make a list of all the records in database RoofGarden
        for (FluxTable fluxTable : tables) {
            List<FluxRecord> records = fluxTable.getRecords();
            for (FluxRecord fluxRecord : records) {
                // Map every record in a POJO
                influxMapper(fluxRecord);
            }
        }
        return getMemoryPointList();
    }

    public List<TemperatureSensor> getMemoryPointList() {
        return memoryPointList;
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = this.jsonStr.concat(jsonStr);
    }

    private void makeJson(TemperatureSensor temperatureSensor){
        ObjectMapper Obj = new ObjectMapper();

        try {
            // get Oraganisation object as a json string
            String jsonStr = Obj.writeValueAsString(temperatureSensor);
            // Displaying JSON String
            System.out.println(jsonStr);
            setJsonStr(jsonStr);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List influxMapper(FluxRecord fluxRecord){
        // Use the fluxMapper to create a POJO
        FluxResultMapper mapper = new FluxResultMapper();
        TemperatureSensor temperatureSensor = mapper.toPOJO(fluxRecord, TemperatureSensor.class);
        memoryPointList.add(temperatureSensor);
        return  memoryPointList;
    }

    // make connection with the influx database
    private InfluxDBClient connectToCloudDatabase(){
        InfluxDBClient client = InfluxDBClientFactory.create(url, token);
        // Gives the status of the connection
        System.out.println(client.health());
        return client;
    }
}
