package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.po.Authenticate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthenticateDAO {
    String TABLE_NAME = "auth";
    String INSET_FIELDS = " username, salt, password ";
    String SELECT_FIELDS = " id, username, salt, password";

    @Insert({"INSERT INTO ",TABLE_NAME," ( ",INSET_FIELDS," ) VALUES (#{username},#{salt},#{password}) " })
    void addAuthenticate(Authenticate authenticate);

    @Select({"SELECT ",SELECT_FIELDS," FROM ",TABLE_NAME," WHERE username = #{username}"})
    List<Authenticate> getAuthByUsername(String username);
}
