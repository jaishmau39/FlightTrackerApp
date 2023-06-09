package com.wileyedge.flighttracker.dao.mapper;

import com.wileyedge.flighttracker.models.Airline;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirlineMapper implements RowMapper<Airline> {
    @Override
    public Airline mapRow(ResultSet rs, int rowNum) throws SQLException {
        Airline airline = new Airline();

        airline.setAirlineId(rs.getInt("airline_id"));
        airline.setAirlineName(rs.getString("airline_name"));
        airline.setAirlineCode(rs.getString("airline_code"));
        return airline;
    }
}
