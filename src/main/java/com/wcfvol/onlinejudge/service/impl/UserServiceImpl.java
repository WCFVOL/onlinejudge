package com.wcfvol.onlinejudge.service.impl;

import com.wcfvol.onlinejudge.mapper.dao.UserDAO;
import com.wcfvol.onlinejudge.mapper.ext.UserMapper;
import com.wcfvol.onlinejudge.pojo.data.User;
import com.wcfvol.onlinejudge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wang Chunfei
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userDAO;
//    @Autowired
//    UserDAO userDAO;

    @Override
    public User getUser(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void addAttempt(String username) {
        userDAO.updateAttempt(username);
    }

    @Override
    public void addSolved(String username) {
        userDAO.updateSolved(username);
    }

    @Override
    public User getUserBySubmissionId(Integer id) {
        return userDAO.getUserBySubmissionId(id);
    }

}
