package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.models.Flight;

import java.util.List;

public interface FlightDBService {

    List<Flight> getAllFlightsByUser(int userId);

    Flight getFlightById(int flightId);
    Flight getFlightByNumber(String flightNumber);

    Flight addFlight(Flight flight);

    Flight updateFlightWithScheduled(Flight flight);

    void removeFlight(int flightId);

}
