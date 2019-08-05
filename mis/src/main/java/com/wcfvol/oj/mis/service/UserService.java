package com.wcfvol.oj.mis.service;

import com.wcfvol.oj.mis.pojo.data.User;

public interface UserService {
    User getUser(String username);
    void addUser(User user);
    void addAttempt(String username);
    void addSolved(String username);
    User getUserBySubmissionId(Integer id);
}
