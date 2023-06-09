package com.wileyedge.flighttracker.models;

public class Airline {
    private int airlineId;
    private String airlineName;
    private String airlineCode;

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return this.airlineName;

    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineCode() {

        return this.airlineCode;

    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }
}