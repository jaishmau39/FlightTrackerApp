package com.wileyedge.flighttracker.dao.mapper;

import com.wileyedge.flighttracker.models.Airport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AirportMapper implements RowMapper<Airport> {

    @Override
    public Airport mapRow(ResultSet rs, int rowNum) throws SQLException {
        Airport airport = new Airport();
        airport.setAirportId(rs.getInt("airport_id"));
        airport.setAirportCode(rs.getString("airport_code"));
        airport.setCity(rs.getString("city"));
        airport.setCountry(rs.getString("country"));
        airport.setTimezone(rs.getString("timezone"));

        return airport;
    }



}


