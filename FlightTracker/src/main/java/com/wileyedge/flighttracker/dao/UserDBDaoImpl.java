package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.dao.mapper.UserMapper;
import com.wileyedge.flighttracker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserDBDaoImpl implements UserDBDao{

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public User addUser(User user) {
        final String sql = "INSERT INTO users(username,email) VALUES(?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserEmail());

            return statement;

        }, keyHolder);
        user.setUserId(keyHolder.getKey().intValue());
        return user;
    }

    @Override
    public User getUserByName(String name) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), name);
        }catch (DataAccessException e){
            return null;
        }
    }
}
