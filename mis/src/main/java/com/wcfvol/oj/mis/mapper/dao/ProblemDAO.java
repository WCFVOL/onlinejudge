package com.wcfvol.oj.mis.mapper.dao;

import com.wcfvol.oj.mis.pojo.data.Problem;
import org.apache.ibatis.annotations.*;

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
            "( #{title},#{description},#{input},#{output},#{sampleInput},#{sampleOutput},#{hint},#{timeLimit}" +
            ",#{memLimit} )"})
    void addProblem(Problem problem);

    @Update({"UPDATE ",TABLE_NAME," SET test_case=test_case+#{num}  WHERE id=#{id}"})
    void updateCaseId(@Param("id") int id,@Param("num") int num);

    @Update({"UPDATE ",TABLE_NAME," SET submit_num = submit_num + 1 WHERE id = #{id}"})
    void updateSubmitNum(int id);

    @Update({"UPDATE ",TABLE_NAME," SET accept_num = accept_num + 1 WHERE id = #{id}"})
    void updateAcceptNum(int id);
}
