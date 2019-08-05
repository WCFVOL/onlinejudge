package com.wcfvol.oj.mis.service;

import com.wcfvol.oj.mis.pojo.data.Authenticate;

import java.util.List;

public interface AuthService {
    boolean judgeUsername(String username);
    boolean saveAuth(Authenticate authenticate);
    List<Authenticate> getAuth(String username);
    String getSalt(String username);
}
