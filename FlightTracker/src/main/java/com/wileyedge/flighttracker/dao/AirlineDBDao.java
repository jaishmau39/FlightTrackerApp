package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.models.Airline;
public interface AirlineDBDao {

    Airline getAirlineByCode(String code);

}
