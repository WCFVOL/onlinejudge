package com.wcfvol.onlinejudge.service.impl;

import com.wcfvol.onlinejudge.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void getUser() {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void addAttempt() {
        userService.addAttempt("000");
    }
}