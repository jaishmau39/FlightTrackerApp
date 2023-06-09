package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.dao.FlightDBDao;
import com.wileyedge.flighttracker.models.Flight;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FlightServiceImplTest {
    private FlightDBServiceImpl flightDBService;

    public FlightServiceImplTest(){
        FlightDBDao flightDBDao = new FlightDaoDBStubImpl();
        flightDBService = new FlightDBServiceImpl(flightDBDao);
    }

    @Test
    public void testFindFlightByUserId() {
        List<Flight> returnedFlights = flightDBService.getAllFlightsByUser(1);
        assertNotNull(returnedFlights);
        System.out.println(returnedFlights);
        assertEquals(1, returnedFlights.size());
    }



}