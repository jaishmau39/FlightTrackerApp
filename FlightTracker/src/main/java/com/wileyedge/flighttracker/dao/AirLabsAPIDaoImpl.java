package com.wileyedge.flighttracker.dao;

import com.google.gson.Gson;
import com.wileyedge.flighttracker.dao.entity.Geography;
import com.wileyedge.flighttracker.dao.jsonHelpers.GsonFactory;
import com.wileyedge.flighttracker.models.Flight;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


@Repository
public class AirLabsAPIDaoImpl implements AirLabsAPIDao{

    private final String API_KEY = new APIKEY().getAPI_KEY();


    @Override
    public List<Flight> getFlightSchedules(String dep, String arr) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airlabs.co/api/v9/schedules?api_key="+API_KEY+"&dep_iata="+dep+"&arr_iata="+arr))
                .build();

        String jsonStr;

        try {
            HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
            jsonStr = resp.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        Gson gson = new Gson();
        GsonFactory f = gson.fromJson(jsonStr, GsonFactory.class);

        return f.buildFlightSchedules();

    }

    @Override
    public Geography getGeography(String flight_number) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://airlabs.co/api/v9/flights?api_key="+API_KEY+"&flight_iata="+flight_number))
                .build();

        String jsonStr;

        try {
            HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
            jsonStr = resp.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        GsonFactory f = gson.fromJson(jsonStr, GsonFactory.class);


        return f.buildGeography();
    }


}
