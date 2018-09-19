package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.pojo.data.Authenticate;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wangchunfei
 */
@Mapper
public interface AuthenticateDAO {

    void addAuthenticate(Authenticate authenticate);

    List<Authenticate> getAuthByUsername(String username);

    String getSaltByUsername(String username);
}
