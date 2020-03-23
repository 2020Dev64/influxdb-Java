package com.abbeloosindustries.repository;

import com.abbeloosindustries.model.SensorData;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// Tests Still in progress
// Created the test by going in the class you want to test go "alt enter" choose create test
class InfluxDBRepositoryImplTest {

    // Create the mock (object) we need.
    @Mock
    InfluxDBRepositoryImpl influxDBRepository;

    // Everytime we test the methods the test will create a new influxDBRepositoryImpl object
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        //influxDBRepository = new InfluxDBRepositoryImpl();
    }

    // The test methods
    @Test
    void readSensorData() {
    }

    @Test
    void getSensorData() {
        // getSensorData returns a list of sensorData so you need to create sensordata and a list of sensordata
        SensorData sensorData = new SensorData();
        List sensorList = new ArrayList();
        sensorList.add(sensorData);

        // Use the mock, here we tell mockito
        when(influxDBRepository.getSensorData()).thenReturn(sensorList);
    }

    @Test
    void writeSensorData() {
    }

    @Test
    void makePojo() {
    }

    @Test
    void getQuery() {
    }
}