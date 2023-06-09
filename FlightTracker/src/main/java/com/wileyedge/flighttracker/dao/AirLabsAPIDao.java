package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.dao.entity.Geography;
import com.wileyedge.flighttracker.models.Flight;

import java.util.List;

public interface AirLabsAPIDao {

    List<Flight> getFlightSchedules(String arr, String dep);

    //Return json
    Geography getGeography(String flight_number);

}
