package com.wcfvol.oj.mis.pojo.data;

import lombok.Data;

@Data
public class ProblemList {
    private Integer id;
    private Integer problemId;
    private String title;
    private String author;
    private String source;
}
