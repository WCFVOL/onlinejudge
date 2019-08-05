package com.wcfvol.oj.mis.mapper.ext;

import com.wcfvol.oj.mis.mapper.dao.UserDAO;
import com.wcfvol.oj.mis.pojo.data.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends UserDAO {
    User getUserBySubmissionId(Integer id);
}
