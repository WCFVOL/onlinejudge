package com.wcfvol.oj.mis.pojo.data;

import lombok.Data;

@Data
public class Authenticate {
    private int id;
    private String username;
    private String salt;
    private String password;
}
