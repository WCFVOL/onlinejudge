package com.wcfvol.onlinejudge.service.impl;

import com.wcfvol.onlinejudge.dao.SubmissionDAO;
import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionDAO submissionDAO;

    @Override
    public void addSubmission(Submission submission) {
        submissionDAO.addSubmission(submission);
    }

    @Override
    public void updateResult(Submission submission) {
        submissionDAO.addResult(submission);
    }

    @Override
    public List<Submission> getAllSubmission() {
        return submissionDAO.getAllSubmission();
    }

    @Override
    public List<Submission> getSubmissionList(int start, int size) {
        return submissionDAO.getSubmissionList(start,size);
    }
}
