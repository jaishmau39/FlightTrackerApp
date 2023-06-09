package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.models.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightDBDaoImplTest {

    @Autowired
    FlightDBDao flightDao;

    @BeforeEach
    public void setUp(){
        flightDao.removeAll();
    };


    @Test
    public void testAddGetRemove(){

        Flight flight = new Flight();
        flight.setFlightId(1);
        flight.setFlightNumber("AC181");
        flight.setAirline("AC");
        flight.setDeparture("YYZ");
        flight.setArrival("YVR");
        flight.setUserId(1);
        flight.setFlightStatus("active");
        flight.setDepartureTime("2023-06-05T06:05:00.000");
        flight.setArrivalTime("2023-06-05T08:16:00.000");
        flight.setArrivalTimeEst("2023-06-05T07:58:00.000");

        Flight addedFlight = flightDao.addFlight(flight);
        Flight retrievedFlight = flightDao.getFlightById(addedFlight.getFlightId());
        List<Flight> flightByUser = flightDao.getAllFlightsByUser(1);

        assertEquals(flight, addedFlight, "Add flight should return the original flight");
        assertEquals(flight, retrievedFlight, "Retrieved flight should be the original flight.");
        assertEquals(1, flightByUser.size(), "List of flights should be 1.");
        assertTrue(flightByUser.contains(flight), "List should contain AC181");

        flightDao.removeFlight(addedFlight.getFlightId());

        List<Flight> noFlights = flightDao.getAllFlightsByUser(1);

        assertEquals(0, noFlights.size(), "No flights should be in DB.");

    }

    @Test
    public void testUpdate(){

        Flight flight = new Flight();
        flight.setFlightNumber("AC181");
        flight.setAirline("AC");
        flight.setDeparture("YYZ");
        flight.setArrival("YVR");
        flight.setUserId(1);
        flight.setFlightStatus("active");
        flight.setDepartureTime("2023-06-05T06:05:00.000");
        flight.setArrivalTime("2023-06-05T08:16:00.000");
        flight.setArrivalTimeEst("2023-06-05T07:58:00.000");


        Flight addedFlight = flightDao.addFlight(flight);


        flightDao.updateFlight(flight);

        Flight updatedFlight = flightDao.getFlightById(addedFlight.getFlightId());


//        assertTrue("35".compareTo(updatedFlight.getLat()) == 0 , "Lat should be 35");
//        assertTrue("-77".compareTo(updatedFlight.getLon()) == 0 , "Lon should be -77");



    }



}