package com.wcfvol.onlinejudge.pojo.params;

import lombok.Data;

/**
 * @author wangchunfei
 */
@Data
public class LoginParam {
    private String username;
    private String password;
    private Boolean isRemember;
}
