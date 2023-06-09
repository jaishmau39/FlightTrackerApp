package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.models.Flight;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightDaoImplTest {

    @Autowired
    FlightDBDao flightDBDao;


    @Before
    public void setUp(){
        List<Flight> flights = flightDBDao.getAllFlightsByUser(1);
        for(Flight flight:flights){
            // delete flights
            flightDBDao.removeFlight(flight.getFlightId());
        }
    }

    @Test
    public void testGetAllFlights() {

        Flight flight = new Flight();
        flight.setFlightNumber("F123");
        flight.setAirline("Air Canada");
        flight.setDeparture("Toronto");
        flight.setArrival("Montreal");
        flight.setUserId(1);

        flightDBDao.addFlight(flight);

        Flight flight2 = new Flight();
        flight2.setFlightNumber("F128");
        flight2.setAirline("Jet Airways");
        flight2.setDeparture("Toronto");
        flight2.setArrival("Montreal");
        flight2.setUserId(1);
        flightDBDao.addFlight(flight2);


        List<Flight> flights = flightDBDao.getAllFlightsByUser(1);

        assertEquals(2, flights.size());
        assertTrue(flights.contains(flight));
        assertTrue(flights.contains(flight2));

    }

    @Test
    public void testAddGetFlight() {

        Flight flight = new Flight();
        flight.setFlightNumber("F123");
        flight.setAirline("Air Canada");
        flight.setDeparture("Toronto");
        flight.setArrival("Montreal");
        flight.setUserId(1);

        Flight addedFlight = flightDBDao.addFlight(flight);
        Flight fromDao = flightDBDao.getFlightById(addedFlight.getFlightId());

        assertEquals(addedFlight, fromDao);
    }

    @Test
    public void testUpdateGame(){

        Flight flight = new Flight();
        flight.setFlightNumber("F123");
        flight.setAirline("Air Canada");
        flight.setDeparture("Toronto");
        flight.setArrival("Montreal");
        flight.setUserId(1);

        Flight addedFlight = flightDBDao.addFlight(flight);
        Flight fromDao = flightDBDao.getFlightById(addedFlight.getFlightId());

        assertEquals(addedFlight, fromDao);

        flight.setAirline("Flair Airlines");

        Flight updatedFlight = flightDBDao.updateFlight(flight);

        assertNotEquals(addedFlight, fromDao);

        fromDao = flightDBDao.getFlightById(updatedFlight.getFlightId());

        assertEquals(updatedFlight, fromDao);
    }

    @Test
    public void testRemoveFlight(){

        Flight flight = new Flight();
        flight.setFlightNumber("F123");
        flight.setAirline("Air Canada");
        flight.setDeparture("Toronto");
        flight.setArrival("Montreal");
        flight.setUserId(1);

        Flight addedFlight = flightDBDao.addFlight(flight);
        Flight flightFromDao = flightDBDao.getFlightById(addedFlight.getFlightId());

        flightDBDao.removeFlight(addedFlight.getFlightId());

        try{
            Flight flightFromDaoAfterDelete = flightDBDao.getFlightById(addedFlight.getFlightId());
        }catch(DataAccessException da){
            return;
        }

    }

}