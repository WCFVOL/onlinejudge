package com.wcfvol.onlinejudge.po;

import lombok.Data;

import java.util.Date;
@Data
public class SubmitPojo {
    private String code;
    private int userId;
    private Date date;
    private int problemId;
}
