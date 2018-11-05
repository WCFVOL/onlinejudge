package com.wcfvol.onlinejudge.pojo.params;

import com.wcfvol.onlinejudge.pojo.PageInfo;
import lombok.Data;

import java.util.Date;

@Data
public class SubmissionsQueryParam extends PageInfo {
    private String code;
    private String username;
    private Date date;
    private Integer problemId;
    private Integer result;
    private Double time;
    private Integer memory;
    private Integer length;
    private Integer language;
}
