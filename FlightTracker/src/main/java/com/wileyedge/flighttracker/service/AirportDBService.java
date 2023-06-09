package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.models.Airport;

public interface AirportDBService  {

    Airport getAirportByCode(String code) throws InvalidAirportCodeException;
}
