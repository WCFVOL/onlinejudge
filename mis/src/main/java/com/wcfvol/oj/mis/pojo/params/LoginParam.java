package com.wcfvol.oj.mis.pojo.params;

import com.wcfvol.oj.mis.pojo.PageInfo;
import lombok.Data;

/**
 * @author wangchunfei
 */
@Data
public class LoginParam extends PageInfo {
    private String username;
    private String password;
    private Boolean isRemember;
}
