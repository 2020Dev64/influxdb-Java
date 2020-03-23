package com.abbeloosindustries.repository;

import com.abbeloosindustries.model.SensorData;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.query.FluxRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfluxDbCRUDRepository {
    // TODO
    // Put all the information in a file and read the data from this file
    String bucket = "Test";
    String organization = "organization";
    String url = "the url";
    // Double test token
    char[] token = "token here".toCharArray();
    // Make the connection final or use a method to create the connection ?
    InfluxDBClient client = InfluxDBClientFactory.create(url, token);

    // A read method with a given query
    void readSensorData(String fluxQuery);

    // to use the pojo's in thymeleaf
    List<SensorData> getSensorData(String fluxQuery);

    // Create and write new data to influx db through point protocol
    void writeSensorData();

    // Create a Json file
    void makeJson(SensorData sensorData);

    SensorData makePojo(FluxRecord fluxRecord);

    String getQuery(String query, String days, String sensorName);
}
