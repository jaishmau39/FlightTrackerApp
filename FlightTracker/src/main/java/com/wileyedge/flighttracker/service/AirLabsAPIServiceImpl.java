package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.dao.AirLabsAPIDao;
import com.wileyedge.flighttracker.dao.AirlineDBDao;
import com.wileyedge.flighttracker.dao.entity.Geography;
import com.wileyedge.flighttracker.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirLabsAPIServiceImpl implements AirLabsAPIService{

    @Autowired
    AirLabsAPIDao apiDao;

    @Override
    public List<Flight> getFlightSchedules(String dep, String arr) {
        return apiDao.getFlightSchedules(dep,arr);
    }

    @Override
    public Geography getGeography(String flight_number) {
        return apiDao.getGeography(flight_number);
    }
}
