package com.wcfvol.onlinejudge.service.impl;

import com.wcfvol.onlinejudge.mapper.dao.AuthenticateDAO;
import com.wcfvol.onlinejudge.pojo.data.Authenticate;
import com.wcfvol.onlinejudge.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthenticateDAO authenticateDAO;
    @Override
    public boolean judgeUsername(String username) {
        List userList = authenticateDAO.getAuthByUsername(username);
        return userList.isEmpty();
    }

    @Override
    public boolean saveAuth(Authenticate authenticate) {
        String username = authenticate.getUsername();
        if (judgeUsername(username)) {
            authenticateDAO.addAuthenticate(authenticate);
            return true;
        }
        return false;
    }

    @Override
    public List<Authenticate> getAuth(String username) {
        return authenticateDAO.getAuthByUsername(username);
    }


    @Override
    public String getSalt(String username) {
        return authenticateDAO.getSaltByUsername(username);
    }
}
