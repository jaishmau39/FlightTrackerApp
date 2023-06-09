package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.models.Airline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AirlineDBDaoImplTest {

    @Autowired
    AirlineDBDao airlineDao;

    @Test
    @DisplayName("Find airline by code")
    public void findAirlineByCode(){

        Airline airline = airlineDao.getAirlineByCode("AC");

        assertNotNull(airline);
        assertEquals("Air Canada", airline.getAirlineName(), "Airline should be Air Canada");

    }
}