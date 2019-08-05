package com.wcfvol.oj.mis.pojo.params;

import com.wcfvol.oj.mis.pojo.PageInfo;
import lombok.Data;

/**
 * @author wangchunfei
 */
@Data
public class AddProblemParam extends PageInfo {
    private String description;
    private String input;
    private String output;
    private String title;
    private String hint;
    private String sampleInput;
    private String sampleOutput;
    private Integer timeLimit;
    private Integer memLimit;
    private String author;
    private String source;
}
