package com.wcfvol.oj.permit.mapper.gen;

import com.wcfvol.oj.permit.pojo.po.UserPO;

public interface UserMapper {
    /**
     *
     * @mbg.generated 2019-08-05
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-08-05
     */
    int insert(UserPO record);

    /**
     *
     * @mbg.generated 2019-08-05
     */
    int insertSelective(UserPO record);


    /**
     *
     * @mbg.generated 2019-08-05
     */
    UserPO selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2019-08-05
     */
    int updateByPrimaryKeySelective(UserPO record);

    /**
     *
     * @mbg.generated 2019-08-05
     */
    int updateByPrimaryKey(UserPO record);
}