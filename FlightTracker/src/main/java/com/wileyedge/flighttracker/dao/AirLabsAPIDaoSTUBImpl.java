package com.wileyedge.flighttracker.dao;

import com.google.gson.Gson;
import com.wileyedge.flighttracker.dao.entity.Geography;
import com.wileyedge.flighttracker.dao.jsonHelpers.GsonFactory;
import com.wileyedge.flighttracker.models.Flight;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


//@Repository
public class AirLabsAPIDaoSTUBImpl implements AirLabsAPIDao {

    @Override
    public List<Flight> getFlightSchedules(String dep, String arr) {
        Path path = Path.of("testdata/AirLabsSchedules.json");
        String jsonStr;
        try {
            jsonStr = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //API CALL

        Gson gson = new Gson();
        GsonFactory f = gson.fromJson(jsonStr, GsonFactory.class);

        return f.buildFlightSchedules();
    }

    @Override
    public Geography getGeography(String flight_number) {

        Path path = Path.of("testdata/AirLabsLive.json");
        String jsonStr;
        try {
            jsonStr = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        GsonFactory f = gson.fromJson(jsonStr, GsonFactory.class);


        return f.buildGeography();
    }



}
