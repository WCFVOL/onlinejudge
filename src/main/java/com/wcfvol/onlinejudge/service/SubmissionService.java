package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.pojo.data.Submission;
import com.wcfvol.onlinejudge.pojo.params.SubmissionsQueryParam;
import com.wcfvol.onlinejudge.pojo.po.SubmitPo;

import java.util.List;

public interface SubmissionService {
    void addSubmission(Submission submission);
    void updateResult(Submission submission);
    List<Submission> getAllSubmission();
    List<Submission> getSubmissionsByParam(SubmissionsQueryParam param);
//    List<Submission> getSubmissionList(int start, int size);
    Submission getSubmissionById(int id);
    Submission getSubmissionByBody(String body);
    SubmitPo getSubmitPojoBySubmission(Submission submission);
}
