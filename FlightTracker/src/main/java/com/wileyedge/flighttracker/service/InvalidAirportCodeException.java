package com.wileyedge.flighttracker.service;

public class InvalidAirportCodeException extends Exception{
    public InvalidAirportCodeException(String s) {
        super(s);
    }
}
