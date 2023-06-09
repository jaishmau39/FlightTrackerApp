package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.dao.mapper.FlightMapper;
import com.wileyedge.flighttracker.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class FlightDBDaoImpl implements FlightDBDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Flight> getAllFlightsByUser(int userId) {
        final String sql = "SELECT * FROM flights where user_id = ?;";
        return jdbcTemplate.query(sql, new FlightMapper(), userId);
    }

    @Override
    public Flight getFlightById(int flightId) {
        final String sql = "SELECT * FROM flights where flight_id = ?;";
        return jdbcTemplate.queryForObject(sql, new FlightMapper(), flightId);
    }

    @Override
    public Flight getFlightByNumber(String flightNumber) {
        final String sql = "SELECT * FROM flights where flight_number = ?;";
        return jdbcTemplate.queryForObject(sql, new FlightMapper(), flightNumber);
    }

    @Override
    public Flight addFlight(Flight flight) {
        final String sql = "INSERT INTO flights(flight_number,airline,departure,arrival,user_id,flight_status,dep_time,arr_time,arr_time_est) VALUES(?,?,?,?,?,?,?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, flight.getFlightNumber());
            statement.setString(2, flight.getAirline());
            statement.setString(3,flight.getDeparture());
            statement.setString(4, flight.getArrival());
            statement.setInt(5, flight.getUserId());
            statement.setString(6, flight.getFlightStatus());
            statement.setString(7, flight.getDepartureTime());
            statement.setString(8, flight.getArrivalTime());
            statement.setString(9, flight.getArrivalTimeEst());
            return statement;

        }, keyHolder);
        flight.setFlightId(keyHolder.getKey().intValue());
        return flight;
    }

    @Override
    public Flight updateFlight(Flight flight) {
        final String UPDATE_FLIGHT = "UPDATE flights SET flight_number = ?, airline = ?,departure = ?,arrival = ?,user_id = ?,flight_status = ?,dep_time=?,arr_time = ?,arr_time_est = ? WHERE flight_id = ?";
        jdbcTemplate.update(UPDATE_FLIGHT,
                flight.getFlightNumber(),
                flight.getAirline(),
                flight.getDeparture(),
                flight.getArrival(),
                flight.getUserId(),
                flight.getFlightStatus(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getArrivalTimeEst(),
                flight.getFlightId());
        return getFlightById(flight.getFlightId());
    }

    @Override
    @Transactional
    public void removeFlight(int flightId) {
        final String DELETE_FLIGHT = "DELETE FROM flights WHERE flight_id=?";
        jdbcTemplate.update(DELETE_FLIGHT, flightId);


    }

    //For testing
    @Override
    @Transactional
    public void removeAll(){
        jdbcTemplate.update("TRUNCATE TABLE flights");
    }
}
