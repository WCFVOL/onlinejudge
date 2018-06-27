package com.wcfvol.onlinejudge.entity;

import lombok.Data;

import java.util.Date;


/**
 * @author Wang Chunfei
 */
@Data
public class Submission {
    private int id;
    private String code;
    private int userId;
    private Date date;
    private int problemId;
    private int result;
    private double time;
    private int memory;
    private int length;
}
