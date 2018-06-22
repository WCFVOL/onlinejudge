package com.wcfvol.onlinejudge.po;
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
}
