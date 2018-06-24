package com.wcfvol.onlinejudge.po;

import lombok.Data;

@Data
public class Authenticate {
    private int id;
    private String username;
    private String salt;
    private String password;
}
