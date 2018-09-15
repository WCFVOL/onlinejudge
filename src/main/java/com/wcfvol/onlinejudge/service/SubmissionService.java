package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.pojo.po.SubmitPo;

import java.util.List;

public interface SubmissionService {
    void addSubmission(Submission submission);
    void updateResult(Submission submission);
    List<Submission> getAllSubmission();
    List<Submission> getSubmissionList(int start, int size);
    Submission getCodeByid(int id);
    Submission getSubmissionByBody(String body);
    SubmitPo getSubmitPojoBysubmission(Submission submission);
}
