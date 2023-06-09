package com.wileyedge.flighttracker.service;

public class InvalidAirlineCodeException extends Exception{
    public InvalidAirlineCodeException(String s) {
        super(s);
    }
}
