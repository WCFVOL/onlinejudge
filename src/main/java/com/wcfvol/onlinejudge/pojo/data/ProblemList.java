package com.wcfvol.onlinejudge.pojo.data;

import lombok.Data;

@Data
public class ProblemList {
    private int id;
    private int problemId;
    private String title;
    private String author;
    private String source;
}
