package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.models.Flight;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FlightDBDao {

    List<Flight> getAllFlightsByUser(int userId);

    Flight getFlightById(int flightId);

    Flight getFlightByNumber(String flightNumber);

    Flight addFlight(Flight flight);

    Flight updateFlight(Flight flight);

    void removeFlight(int flightId);

    @Transactional
    void removeAll();
}
