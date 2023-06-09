package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.dao.AirportDBDao;
import com.wileyedge.flighttracker.models.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportDBServiceImpl implements AirportDBService{

    @Autowired
    AirportDBDao dao;

    @Override
    public Airport getAirportByCode(String code) throws InvalidAirportCodeException {


        isValidAirportCode(code);

        Airport airport = dao.getAirportByCode(code);
        if (airport == null) {
            Airport unknown = new Airport();
            unknown.setAirportCode(code);
            unknown.setCity("Unknown");
            unknown.setCountry("Unknown");
            return unknown;
        }
        return airport;

    }


    public void isValidAirportCode(String code) throws InvalidAirportCodeException {

        if( !code.matches("[a-zA-Z]{3}")){
            throw new InvalidAirportCodeException("Invalid Airport code.");
        }




    }
}
