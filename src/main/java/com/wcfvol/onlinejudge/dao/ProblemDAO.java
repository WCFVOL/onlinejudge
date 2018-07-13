package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.entity.Problem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Wang Chunfei
 */
@Mapper
public interface ProblemDAO {
    String TABLE_NAME = "problem";
    String INSET_FIELDS = " title, description, input, output, sample_input, " +
            "sample_output, hint ,time_limit ,mem_limit ";
    String SELECT_FIELDS = " id, title, description, input, output, sample_input, sample_output, " +
            "hint ,time_limit ,mem_limit ,submit_num ,accept_num, test_case";

    @Select({"SELECT ",SELECT_FIELDS," FROM ",TABLE_NAME, " WHERE id=#{id}"})
    Problem getProblemById(int id);

    @Insert({"INSERT INTO ",TABLE_NAME," ( ",INSET_FIELDS, " ) VALUES " +
            "( #{title},#{description},#{input},#{output},#{sampleInput},#{sampleOutput},#{hint},#{time_limit}" +
            ",#{mem_limit} )"})
    void addProblem(Problem problem);

    @Update({"UPDATE ",TABLE_NAME," SET test_case=test_case+1  WHERE id=#{id}"})
    void updateCaseId(int id);
}
