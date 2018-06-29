package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.entity.Submission;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface SubmissionDAO {
    String TABLE_NAME = "submissions";
    String INSERT_FIELDS_SUBMIT = " code, user_id, date, problem_id ,language ";
    String UPDATE_FIELDS_RESULT = " result, time, memory, length ";
    String SELECT_FIELDS = " id, code, user_id, date, problem_id, result, time, memory, length ,language";

    @Insert({"INSERT INTO ",TABLE_NAME,"(",INSERT_FIELDS_SUBMIT,") VALUES (#{code},#{userId},#{date},#{problemId}),#{language} "})
    void addSubmission(Submission submission);

    @Update({"UPDATE ",TABLE_NAME," code=#{code},user_id#{userId},date=#{date},problem_id=#{problemId}  WHERE id=#{id}"})
    void addResult(Submission submission);

    @Select({"SELECT ",SELECT_FIELDS," FROM ",TABLE_NAME})
    List<Submission> getAllSubmission();
}
