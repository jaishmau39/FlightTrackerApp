package com.wileyedge.flighttracker.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {

    private int flightId;
    private String flightNumber;
    private int userId;
    private String airline;
    private String departure;
    private String arrival;
    private String flightStatus;
    private String departureTime;
    private String arrivalTime;
    private String arrivalTimeEst;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalTimeEst() {
        return arrivalTimeEst;
    }

    public void setArrivalTimeEst(String arrivalTimeEst) {
        this.arrivalTimeEst = arrivalTimeEst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId && userId == flight.userId && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(airline, flight.airline) && Objects.equals(departure, flight.departure) && Objects.equals(arrival, flight.arrival) && Objects.equals(flightStatus, flight.flightStatus) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(arrivalTime, flight.arrivalTime) && Objects.equals(arrivalTimeEst, flight.arrivalTimeEst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNumber, userId, airline, departure, arrival, flightStatus, departureTime, arrivalTime, arrivalTimeEst);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightNumber='" + flightNumber + '\'' +
                ", userId=" + userId +
                ", airline='" + airline + '\'' +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", flightStatus='" + flightStatus + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", arrivalTimeEst='" + arrivalTimeEst + '\'' +
                '}';
    }
}
