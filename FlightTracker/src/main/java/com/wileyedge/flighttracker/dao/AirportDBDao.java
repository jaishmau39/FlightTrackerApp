package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.models.Airport;
public interface AirportDBDao {

    Airport getAirportByCode(String code);

}
