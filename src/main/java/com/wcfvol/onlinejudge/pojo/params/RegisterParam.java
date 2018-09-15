package com.wcfvol.onlinejudge.pojo.params;

import lombok.Data;

/**
 * @author wangchunfei
 */
@Data
public class RegisterParam {
    private String username;
    private String checkPassword;
    private String password;
    private String email;
}
