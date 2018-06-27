package com.wcfvol.onlinejudge.entity;
import lombok.Data;

/**
 * @author Wang Chunfei
 */
@Data
public class Problem {
    private int id;
    private String title;
    private String description;
    private String input;
    private String output;
    private String sampleInput;
    private String sampleOutput;
    private String hint;
    // TODO: 2018/6/27 时间限制 内存限制  提交数 通过数
}
