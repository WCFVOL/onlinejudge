package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.po.User;

public interface UserService {
    User getUser(String username);
    void addUser(User user);
}
