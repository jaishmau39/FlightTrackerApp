package com.wileyedge.flighttracker.dao.jsonHelpers;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.wileyedge.flighttracker.dao.entity.Geography;
import com.wileyedge.flighttracker.models.Flight;
import java.util.ArrayList;
import java.util.List;

public class GsonFactory {

    @SerializedName("request")
    private LinkedTreeMap request;
    @SerializedName("params")
    private LinkedTreeMap params;

    @SerializedName("version")
    private int version;

    @SerializedName("method")
    private LinkedTreeMap method;

    @SerializedName("client")
    private LinkedTreeMap client;

    @SerializedName("connection")
    private LinkedTreeMap connection;

    @SerializedName("device")
    private LinkedTreeMap device;

    @SerializedName("agent")
    private LinkedTreeMap agent;

    @SerializedName("karma")
    private LinkedTreeMap karma;

    @SerializedName("response")
    private ArrayList<LinkedTreeMap> response;


    public ArrayList<LinkedTreeMap> getResponse() {
        return response;
    }

    public List<Flight> buildFlightSchedules(){

        List<Flight> builtFlights = new ArrayList<>();


        for (LinkedTreeMap flightJson: response ) {


            //Porter changed their call sign and it is causing problems
            if( flightJson.get("cs_flight_number") != null
                    || getStr(flightJson.get("airline_iata")).compareTo("P3") == 0
                    ||  getStr(flightJson.get("airline_iata")).compareTo("PD") == 0 ){
                continue;
            }


            Flight aFlight = new Flight();

            aFlight.setAirline(getStr(flightJson.get("airline_iata") ) );
            aFlight.setFlightStatus(getStr(flightJson.get("status")));
            aFlight.setFlightNumber(getStr(flightJson.get("flight_iata")));
            aFlight.setDeparture(getStr( flightJson.get("dep_iata")));
            aFlight.setArrival(getStr( flightJson.get("arr_iata")));

            aFlight.setDepartureTime(getStr(flightJson.get("dep_time")));
            aFlight.setArrivalTime(getStr( flightJson.get("arr_time")));
            aFlight.setArrivalTimeEst(getStr(flightJson.get("arr_estimated")) );

            builtFlights.add(aFlight);
        }
        return builtFlights;
    }

    public Geography buildGeography(){
        Geography geo = new Geography();

        if(response.isEmpty()){
            return geo;
        }

        LinkedTreeMap geoJson = response.get(0);

        geo.setLat( getDouble(geoJson.get("lat")));
        geo.setLng( getDouble(geoJson.get("lng")));
        geo.setAlt( getDouble(geoJson.get("alt")));
        geo.setDir( getDouble(geoJson.get("dir")));
        geo.setSpeed( getDouble(geoJson.get("speed")));


        return geo;

    }

    private static double getDouble(Object o){
        return o == null? 0.0 : (double) o;
    }
    private static String getStr(Object o){

        return  o == null ? null : o.toString();
    }


}
