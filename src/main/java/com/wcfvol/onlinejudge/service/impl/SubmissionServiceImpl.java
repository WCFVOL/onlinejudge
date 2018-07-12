package com.wcfvol.onlinejudge.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.dao.SubmissionDAO;
import com.wcfvol.onlinejudge.entity.Problem;
import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.po.SubmitPojo;
import com.wcfvol.onlinejudge.service.ProblemService;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionDAO submissionDAO;
    @Autowired
    private ProblemService problemService;

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

    @Override
    public Submission getCodeByid(int id) {
        return submissionDAO.getCodeById(id);
    }

    @Override
    public Submission getSubmissionByBody(String body) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        Submission submission = new Submission();
        submission.setCode(jsonBody.getString("code"));
        submission.setDate(jsonBody.getDate("date"));
        submission.setProblemId(jsonBody.getInteger("problem_id"));
        submission.setUsername(jsonBody.getString("username"));
        submission.setLanguage(jsonBody.getInteger("language"));
        return submission;
    }

    @Override
    public SubmitPojo getSubmitPojoBysubmission(Submission submission) {
        SubmitPojo submitPojo = new SubmitPojo();
        submitPojo.setLanguage(submission.getLanguage());
        submitPojo.setUsername(submission.getUsername());
        submitPojo.setProblemId(submission.getProblemId());
        submitPojo.setCode(submission.getCode());
        submitPojo.setMemLimit(submission.getMemory());
        Problem problem =  problemService.getProblemById(submission.getProblemId());
        submitPojo.setTimeLimit(problem.getTimeLimit());
        submitPojo.setMemLimit(problem.getMemLimit());
        submitPojo.setTestCase(problem.getTestCase());
        return submitPojo;
    }
}
