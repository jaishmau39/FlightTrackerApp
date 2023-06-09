package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.dao.FlightDBDao;
import com.wileyedge.flighttracker.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightDBServiceImpl implements FlightDBService{

    @Autowired
    FlightDBDao dao;

    public FlightDBServiceImpl(FlightDBDao flightDBDao){
        this.dao = flightDBDao;
    }

    @Override
    public List<Flight> getAllFlightsByUser(int userId) {
        return dao.getAllFlightsByUser(userId);
    }

    @Override
    public Flight getFlightById(int flightId) {
        return dao.getFlightById(flightId);
    }

    @Override
    public Flight getFlightByNumber(String flightNumber) {
        return dao.getFlightByNumber(flightNumber);
    }


    @Override
    public Flight addFlight(Flight flight) {
        return dao.addFlight(flight);
    }



    @Override
    public Flight updateFlightWithScheduled(Flight flight) {

        Flight currentData = dao.getFlightByNumber(flight.getFlightNumber());

        currentData.setDepartureTime(flight.getDepartureTime());
        currentData.setArrivalTime(flight.getArrivalTime());
        currentData.setArrivalTimeEst(flight.getArrivalTimeEst());
        currentData.setFlightStatus(flight.getFlightStatus());

        return dao.updateFlight(currentData);
    }

    @Override
    public void removeFlight(int flightId) {
        dao.removeFlight(flightId);
    }
}
