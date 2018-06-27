package com.wcfvol.onlinejudge.entity;

import lombok.Data;

@Data
public class ProblemList {
    private int id;
    private int problemId;
    private String title;
    private String author;
    private String source;
}
