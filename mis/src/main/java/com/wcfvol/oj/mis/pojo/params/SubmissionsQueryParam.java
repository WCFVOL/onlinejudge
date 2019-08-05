package com.wcfvol.oj.mis.pojo.params;

import com.wcfvol.oj.mis.pojo.PageInfo;
import lombok.Data;

import java.util.Date;

@Data
public class SubmissionsQueryParam extends PageInfo {
    private String username;
    private Date date;
    private Integer problemId;
    private Integer result;
    private Integer language;
}
