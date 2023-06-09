package com.wileyedge.flighttracker.controllers;


import com.wileyedge.flighttracker.dao.entity.Geography;
import com.wileyedge.flighttracker.models.Flight;
import com.wileyedge.flighttracker.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/external")
public class AirLabsAPIController {


    @Autowired
    AirportDBService airportService;

    @Autowired
    AirlineDBService airlineService;

    @Autowired
    AirLabsAPIService apiService;

    @GetMapping("/schedules")
    public List<HashMap> getSchedules(@RequestParam String dep, @RequestParam String arr) throws InvalidAirportCodeException, InvalidAirlineCodeException {


        List<Flight> flights = apiService.getFlightSchedules(dep,arr);
        List<HashMap> resp = new ArrayList<>();

        for(Flight flight: flights){
            HashMap<String, Object> data = new HashMap<>();

            data.put("flight", flight);
            data.put("arrival", airportService.getAirportByCode(flight.getArrival()));
            data.put("departure", airportService.getAirportByCode(flight.getDeparture()));
            data.put("airline", airlineService.getAirlineByCode(flight.getAirline()));

            resp.add(data);
        }


        return resp;
    }

    @GetMapping("/geography")
    public Geography getLiveFlightGeography(@RequestParam String flight_iata){
        return apiService.getGeography(flight_iata);
    }

}
