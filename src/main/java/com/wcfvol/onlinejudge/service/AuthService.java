package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.pojo.data.Authenticate;

import java.util.List;

public interface AuthService {
    boolean judgeUsername(String username);
    boolean saveAuth(Authenticate authenticate);
    List<Authenticate> getAuth(String username);
    String getSalt(String username);
}
