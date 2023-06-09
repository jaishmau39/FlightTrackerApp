package com.wileyedge.flighttracker.controllers;

import com.wileyedge.flighttracker.models.Flight;
import com.wileyedge.flighttracker.models.User;
import com.wileyedge.flighttracker.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/server")
public class MySQLDBController {

    @Autowired
    AirportDBService airportService;

    @Autowired
    AirlineDBService airlineService;

    @Autowired
    FlightDBService flightService;

    @Autowired
    UserDBService userService;

    @PostMapping("/flights")
    @ResponseStatus(HttpStatus.CREATED)
    public Flight addFlight(@RequestBody Flight flight){

       return flightService.addFlight(flight);

    }

    @GetMapping("/flights/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<HashMap> getFlightsByUser(@PathVariable int userId) throws InvalidAirportCodeException, InvalidAirlineCodeException {

        List<Flight> flights = flightService.getAllFlightsByUser(userId);
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

    @GetMapping("/detail/{flightNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getFlight(@PathVariable String flightNumber) throws InvalidAirportCodeException, InvalidAirlineCodeException {

        //TODO MAKE getflight by flight number in service

         Flight flight = flightService.getFlightByNumber(flightNumber);

         HashMap<String, Object> data = new HashMap<>();
        data.put("flight", flight);
        data.put("arrival", airportService.getAirportByCode(flight.getArrival()));
        data.put("departure", airportService.getAirportByCode(flight.getDeparture()));
        data.put("airline", airlineService.getAirlineByCode(flight.getAirline()));
        return data;

    }


    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> removeFlight(@PathVariable int flightId) {
        flightService.removeFlight(flightId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){

        return userService.addUser(user);

    }

    @GetMapping("/users/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable String userName)  {

        User user = userService.getUserByName(userName);
        return user;

    }

    @DeleteMapping("/flight/{flightId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFlight(@PathVariable int flightId){
        System.out.println(flightId);
        flightService.removeFlight(flightId);
    }



}
