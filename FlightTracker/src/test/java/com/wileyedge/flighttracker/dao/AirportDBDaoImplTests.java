package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.models.Airport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AirportDBDaoImplTests {


    @Autowired
    AirportDBDao airportDBDao;


    @Test
    @DisplayName("Find A Airport By code: YYZ")
    public void findAirportByCodeTest() {

        Airport airport = airportDBDao.getAirportByCode("YYZ");

        assertNotNull(airport);
        assertEquals("Toronto", airport.getCity(), "City should be Toronto");

    }



}
