package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.entity.Submission;

import java.util.List;

public interface SubmissionService {
    void addSubmission(Submission submission);
    void updateResult(Submission submission);
    List<Submission> getAllSubmission();
}
