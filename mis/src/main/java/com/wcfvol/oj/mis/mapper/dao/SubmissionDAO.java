package com.wcfvol.oj.mis.mapper.dao;

import com.wcfvol.oj.mis.pojo.data.Submission;
import com.wcfvol.oj.mis.pojo.params.SubmissionsQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubmissionDAO {
    String TABLE_NAME = "submissions";
    String INSERT_FIELDS_SUBMIT = " code, username, date, problem_id ,language ";
    String UPDATE_FIELDS_RESULT = " result, time, memory, length ";
    String SELECT_FIELDS = " id, username, date, problem_id, result, time, memory, length ,language";
    String SELECT_LIST = " id, username, date, problem_id, result, time, memory, length ,language";

    @Insert({"INSERT INTO ",TABLE_NAME,"(",INSERT_FIELDS_SUBMIT,") VALUES (#{code},#{username},#{date},#{problemId},#{language}) "})
    void addSubmission(Submission submission);

//    @Update({"UPDATE ",TABLE_NAME," SET result=#{result}, time=#{time}, memory=#{memory}, length=#{length}  WHERE id=#{id}"})
    void addResult(Submission submission);

//    @Select({"SELECT ",SELECT_FIELDS," FROM ",TABLE_NAME,"ORDER BY id DESC"})
    List<Submission> getAllSubmission();

    List<Submission> getSubmissionsByParam(SubmissionsQueryParam submissionsQueryParam);
//    @Select({"SELECT ", SELECT_LIST," FROM ",TABLE_NAME," LIMIT #{start}, #{size}"})
//    List<Submission> getSubmissionList(@Param("start") int start, @Param("size") int size);

//    @Select({"SELECT * FROM ",TABLE_NAME, " where id = #{id} " })
    Submission getSubmissionById(int id);
}
