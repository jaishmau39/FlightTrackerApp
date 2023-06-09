package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.models.User;

public interface UserDBService {

    User addUser(User user);
    User getUserByName(String name);
}
