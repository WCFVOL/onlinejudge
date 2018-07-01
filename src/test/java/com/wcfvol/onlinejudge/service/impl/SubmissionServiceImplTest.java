package com.wcfvol.onlinejudge.service.impl;

import com.wcfvol.onlinejudge.dao.SubmissionDAO;
import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SubmissionServiceImplTest {
    @Autowired
    SubmissionService submissionService;
    @Test
    public void addSubmission() {
    }

    @Test
    public void updateResult() {
        Submission submission = new Submission();
        //     @Update({"UPDATE ",TABLE_NAME,"
        // result=#{result},time#{time},memory=#{memory},length=#{length}  WHERE id=#{id}"})
        submission.setId(5);
        submission.setResult(1);
        submission.setTime(5);
        submission.setMemory(5);
        submission.setLength(100);
        submissionService.updateResult(submission);

    }

    @Test
    public void getAllSubmission() {
    }
}