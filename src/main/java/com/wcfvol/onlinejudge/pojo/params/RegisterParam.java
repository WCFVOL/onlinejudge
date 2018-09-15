package com.wcfvol.onlinejudge.pojo.params;

import com.wcfvol.onlinejudge.pojo.PageInfo;
import lombok.Data;

/**
 * @author wangchunfei
 */
@Data
public class RegisterParam extends PageInfo {
    private String username;
    private String checkPassword;
    private String password;
    private String email;
}
