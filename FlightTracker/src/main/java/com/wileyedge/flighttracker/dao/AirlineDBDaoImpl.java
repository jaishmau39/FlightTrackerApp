package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.dao.mapper.AirlineMapper;
import com.wileyedge.flighttracker.models.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AirlineDBDaoImpl implements AirlineDBDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Airline getAirlineByCode(String code) {
        String sql = "SELECT * FROM airlines WHERE airline_code = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new AirlineMapper(), code);
        }catch (DataAccessException e){
            return null;
        }
    }

}
