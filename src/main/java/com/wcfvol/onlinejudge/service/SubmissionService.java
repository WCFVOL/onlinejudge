package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.po.ResultPojo;
import com.wcfvol.onlinejudge.po.SubmitPojo;

import java.util.List;

public interface SubmissionService {
    void addSubmission(SubmitPojo submitPojo);
    void updateResult(ResultPojo resultPojo);
    List<Submission> getAllSubmission();
}
