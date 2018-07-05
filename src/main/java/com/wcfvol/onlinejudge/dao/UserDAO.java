package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.entity.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserDAO {
    String TABLE_NAME = "user";
    String INSET_FIELDS = " username, email, solved, attempt, isAdmin ";
    String SELECT_FIELDS = " id, isAdmin, username, email, solved, attempt ";

    @Select({" SELECT ",SELECT_FIELDS," FROM ",TABLE_NAME," WHERE username = #{username} "})
    User getUserByUsername(String username);

    @Insert({"INSERT INTO ",TABLE_NAME," ( ",INSET_FIELDS," ) VALUE ( #{username}, #{email}, #{solved}, #{attempt}, #{isAdmin} ) "})
    void addUser(User user);
}
