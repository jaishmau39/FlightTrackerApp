package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.dao.FlightDBDao;
import com.wileyedge.flighttracker.models.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightDaoDBStubImpl implements FlightDBDao {

    public Flight onlyFlight;

    public FlightDaoDBStubImpl(){
        onlyFlight = new Flight();
        onlyFlight.setFlightNumber("F123");
        onlyFlight.setAirline("Air Canada");
        onlyFlight.setDeparture("Toronto");
        onlyFlight.setArrival("Montreal");
        onlyFlight.setUserId(1);
    }

    @Override
    public List<Flight> getAllFlightsByUser(int userId) {
        List<Flight> flights = new ArrayList<>();
        flights.add(onlyFlight);
        return flights;
    }

    @Override
    public Flight getFlightById(int flightId) {
        if(flightId == onlyFlight.getFlightId()){
            return onlyFlight;
        }
        return null;
    }

    @Override
    public Flight getFlightByNumber(String flightNumber) {
        return null;
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flight;
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return null;
    }

    @Override
    public void removeFlight(int flightId) {

    }

    @Override
    public void removeAll() {

    }


}
