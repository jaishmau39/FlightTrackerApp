package com.wileyedge.flighttracker.service;

import com.wileyedge.flighttracker.dao.UserDBDao;
import com.wileyedge.flighttracker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserDBServiceImpl implements UserDBService {

    @Autowired
    UserDBDao dao;

    public UserDBServiceImpl(UserDBDao userDBDao){
        this.dao = userDBDao;
    }
    @Override
    public User addUser(User user) {

        if(dao.getUserByName(user.getUserName())!=null){
            user.setUserName("Duplicate name, user NOT added");
            user.setUserEmail("Duplicate name, user NOT added");

        }

            return dao.addUser(user);
    }

    @Override
    public User getUserByName(String name) {

        try{
            return dao.getUserByName(name);
        } catch (DataAccessException e) {
            // Handle DataAccessException here
            User user = new User();
            user.setUserName("User Not Found");
            user.setUserEmail("User Not Found");
            return user;
        }

    }

}
