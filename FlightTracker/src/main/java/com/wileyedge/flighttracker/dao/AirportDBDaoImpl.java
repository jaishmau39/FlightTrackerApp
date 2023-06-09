package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.dao.mapper.AirportMapper;
import com.wileyedge.flighttracker.models.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AirportDBDaoImpl implements AirportDBDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Airport getAirportByCode(String code) {
        String sql = "SELECT * FROM airports WHERE airport_code = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new AirportMapper(), code);
        }catch (DataAccessException e){
            return null;
        }
    }
}
