package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.models.Airline;

public interface AirlineDBService {

    Airline getAirlineByCode(String code) throws InvalidAirlineCodeException;

}
