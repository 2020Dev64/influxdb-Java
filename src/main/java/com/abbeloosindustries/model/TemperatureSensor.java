package com.abbeloosindustries.model;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import java.time.Instant;

@Measurement(name = "sensor")
public class TemperatureSensor {

    //@Column(name = “XXX”) annotation with the name of the corresponding field.
    //QueryResults are mapped to POJOs with an InfluxDBResultMapper.
    @Column(name = "result")
    private String result;

    @Column(name = "table")
    private Long table;

    @Column(name = "_start")
    private Instant startTime;

    @Column(name = "_stop")
    private Instant stoppedTime;

    @Column(name = "_time")
    private Instant totalTime;

    @Column(name = "_value")
    private Long value;

    @Column(name = "RoofGarden")
    private String roofGarden;

    @Column(name = "_field")
     private String field;

    @Column(name = "_measurement")
    private String name;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getTable() {
        return table;
    }

    public void setTable(Long table) {
        this.table = table;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getStoppedTime() {
        return stoppedTime;
    }

    public void setStoppedTime(Instant stoppedTime) {
        this.stoppedTime = stoppedTime;
    }

    public Instant getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Instant totalTime) {
        this.totalTime = totalTime;
    }


    public String getRoofGarden() {
        return roofGarden;
    }

    public void setRoofGarden(String roofGarden) {
        this.roofGarden = roofGarden;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MemoryPoint{" +
                "result='" + result + '\'' +
                ", table='" + table + '\'' +
                ", startTime=" + startTime +
                ", stoppedTime=" + stoppedTime +
                ", totalTime=" + totalTime +
                ", value=" + value +
                ", roofGarden='" + roofGarden + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}