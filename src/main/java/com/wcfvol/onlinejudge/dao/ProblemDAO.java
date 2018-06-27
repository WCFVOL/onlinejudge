package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.po.Problem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Wang Chunfei
 */
@Mapper
public interface ProblemDAO {
    String TABLE_NAME = "problem";
    String INSET_FIELDS = " title, description, input, output, sample_input, sample_output, hint ";
    String SELECT_FIELDS = " id, title, description, input, output, sample_input, sample_output, hint ";

    @Select({"SELECT ",SELECT_FIELDS," FROM ",TABLE_NAME, " WHERE id=#{id}"})
    Problem getProblemById(int id);

    @Insert({"INSERT INTO ",TABLE_NAME," ( ",INSET_FIELDS, " ) VALUES " +
            "( #{title},#{description},#{input},#{output},#{sampleInput},#{sampleOutput},#{hint} )"})
    void addProblem(Problem problem);
}
