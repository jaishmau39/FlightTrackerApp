package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.dao.AirlineDBDao;
import com.wileyedge.flighttracker.models.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AirlineDBServiceImpl implements AirlineDBService{

    @Autowired
    AirlineDBDao dao;

    @Override
    public Airline getAirlineByCode(String code) throws InvalidAirlineCodeException {
        isValidAirlineCode(code);
        Airline airline = dao.getAirlineByCode(code);

        if(airline == null){
            Airline unknown = new Airline();
            unknown.setAirlineCode("Unknown");
            unknown.setAirlineName("Unknown");
            return unknown;
        }

        return airline;

    }


    public void isValidAirlineCode(String code) throws InvalidAirlineCodeException {

        if(!code.matches("[a-zA-Z0-9]{2}") ){
            throw new InvalidAirlineCodeException("Airline code not valid");
        }

    }
}
