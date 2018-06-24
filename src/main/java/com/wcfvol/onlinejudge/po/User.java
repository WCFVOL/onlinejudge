package com.wcfvol.onlinejudge.po;

import lombok.Data;

@Data
public class User {
    private int id;
    private int userId;
    private String username;
    private String email;
    private int solved;
    private int attempt;
}
