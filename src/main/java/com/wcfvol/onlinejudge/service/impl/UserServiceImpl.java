package com.wcfvol.onlinejudge.service.impl;

import com.wcfvol.onlinejudge.dao.UserDAO;
import com.wcfvol.onlinejudge.po.User;
import com.wcfvol.onlinejudge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wang Chunfei
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User getUser(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

}
