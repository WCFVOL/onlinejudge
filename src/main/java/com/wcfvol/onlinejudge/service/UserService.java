package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.po.User;

public interface UserService {
    User getUser(int userId);
    void addUser(User user);
}
