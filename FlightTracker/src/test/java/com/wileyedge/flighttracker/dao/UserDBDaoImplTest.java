package com.wileyedge.flighttracker.dao;

import com.wileyedge.flighttracker.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserDBDaoImplTest {

    @Autowired
    UserDBDao userDBDao;

    @Test
    @DisplayName("Create New User Test")
    public void createNewCourseTest() {
        User user = new User();
        user.setUserId(2);
        user.setUserName("TestName");
        user.setUserEmail("abc@gmail.com");
        User addedUser = userDBDao.addUser(user);
        assertEquals("abc@gmail.com", addedUser.getUserEmail(), "Email should be abc@gmail.com");
    }

    @Test
    @DisplayName("Find A User By name: FreqFlyer")
    public void findUserByNameTest() {

        User user = userDBDao.getUserByName("FreqFlyer");

        assertNotNull(user);
        assertEquals("freq@flyer.com", user.getUserEmail(), "Email should be freq@flyer.com");

    }


}
