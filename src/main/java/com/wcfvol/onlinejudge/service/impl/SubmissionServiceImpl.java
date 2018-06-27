package com.wcfvol.onlinejudge.service.impl;

import com.wcfvol.onlinejudge.dao.SubmissionDAO;
import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.po.ResultPojo;
import com.wcfvol.onlinejudge.po.SubmitPojo;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionDAO submissionDAO;

    @Override
    public void addSubmission(SubmitPojo submitPojo) {
        submissionDAO.addSubmission(submitPojo.getCode(),submitPojo.getUserId(),submitPojo.getDate(),submitPojo.getProblemId());
    }

    @Override
    public void updateResult(ResultPojo resultPojo) {
        submissionDAO.addResult(resultPojo.getId(),resultPojo.getResult(),resultPojo.getTime(),resultPojo.getMemory(),resultPojo.getLength());
    }

    @Override
    public List<Submission> getAllSubmission() {
        return submissionDAO.getAllSubmission();
    }
}
