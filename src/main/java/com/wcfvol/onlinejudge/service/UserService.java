package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.entity.User;

public interface UserService {
    User getUser(String username);
    void addUser(User user);
    void addAttempt(String username);
}
