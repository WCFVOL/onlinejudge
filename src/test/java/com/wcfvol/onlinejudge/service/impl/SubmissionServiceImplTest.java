package com.wcfvol.onlinejudge.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wcfvol.onlinejudge.pojo.PageInfo;
import com.wcfvol.onlinejudge.pojo.data.Submission;
import com.wcfvol.onlinejudge.pojo.params.SubmissionsQueryParam;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Ignore
public class SubmissionServiceImplTest {
    @Autowired
    SubmissionService submissionService;
    @Test
    public void addSubmission() {
    }

    @Test
    public void getSubmissionByParams() {
        //PageHelper.startPage(1,20);
       Page page = (Page)submissionService.getSubmissionsByParam(new SubmissionsQueryParam());
        System.out.println(page);
    }
    @Test
    public void updateResult() {
        Submission submission = new Submission();
        //     @Update({"UPDATE ",TABLE_NAME,"
        // result=#{result},time#{time},memory=#{memory},length=#{length}  WHERE id=#{id}"})
        submission.setId(5);
        submission.setResult(1);
        submission.setTime(5.0);
        submission.setMemory(5);
        submission.setLength(100);
        submissionService.updateResult(submission);

    }

    @Test
    public void getAllSubmission() {
        System.out.println(submissionService.getAllSubmission());
    }
}
