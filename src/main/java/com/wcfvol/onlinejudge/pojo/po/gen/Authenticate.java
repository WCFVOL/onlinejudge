package com.wcfvol.onlinejudge.pojo.po.gen;

import lombok.Data;

@Data
public class Authenticate {
    private int id;
    private String username;
    private String salt;
    private String password;
}
