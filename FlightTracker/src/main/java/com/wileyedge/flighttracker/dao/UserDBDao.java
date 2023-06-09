package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.models.User;

public interface UserDBDao {

    User addUser(User user);
    User getUserByName(String name);

}
