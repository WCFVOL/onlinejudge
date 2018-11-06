package com.wcfvol.onlinejudge.mapper.ext;

import com.wcfvol.onlinejudge.mapper.dao.UserDAO;
import com.wcfvol.onlinejudge.pojo.data.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends UserDAO {
    User getUserBySubmissionId(Integer id);
}
