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
    private int    timeLimit;
    private int    memLimit;
    private int    submitNum;
    private int    acceptNum;
    private int    testCase;
}
