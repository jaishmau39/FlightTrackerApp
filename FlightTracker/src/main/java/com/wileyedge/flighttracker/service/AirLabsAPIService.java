package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.dao.entity.Geography;
import com.wileyedge.flighttracker.models.Flight;

import java.util.List;


public interface AirLabsAPIService {
    List<Flight> getFlightSchedules(String dep, String arr);

    Geography getGeography(String flight_number);
}
