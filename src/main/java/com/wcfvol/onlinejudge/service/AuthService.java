package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.pojo.po.gen.Authenticate;

import java.util.List;

public interface AuthService {
    boolean judgeUsername(String username);
    boolean saveAuth(Authenticate authenticate);
    List<Authenticate> getAuth(String username);
    String getSalt(String username);
}
