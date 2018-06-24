package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.po.Authenticate;

public interface AuthService {
    boolean judgeUsername(String username);
    boolean saveAuth(Authenticate authenticate);
}
