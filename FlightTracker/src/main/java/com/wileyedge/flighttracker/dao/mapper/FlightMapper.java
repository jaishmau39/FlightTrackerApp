package com.wileyedge.flighttracker.dao.mapper;

import com.wileyedge.flighttracker.models.Flight;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public final class FlightMapper implements RowMapper<Flight> {
    @Override
    public Flight mapRow(ResultSet rs, int index) throws SQLException {
        Flight fl = new Flight();
        fl.setFlightId(rs.getInt("flight_id"));
        fl.setFlightNumber(rs.getString("flight_number"));
        fl.setAirline(rs.getString("airline"));
        fl.setDeparture(rs.getString("departure"));
        fl.setArrival(rs.getString("arrival"));
        fl.setUserId(rs.getInt("user_id"));
        fl.setFlightStatus(rs.getString("flight_status"));
        fl.setDepartureTime(rs.getString("dep_time"));
        fl.setArrivalTime(rs.getString("arr_time"));
        fl.setArrivalTimeEst(rs.getString("arr_time_est"));
        return fl;
    }
}