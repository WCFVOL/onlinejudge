package com.wcfvol.oj.mis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.oj.mis.mapper.dao.SubmissionDAO;
import com.wcfvol.oj.mis.pojo.data.Problem;
import com.wcfvol.oj.mis.pojo.data.Submission;
import com.wcfvol.oj.mis.pojo.params.SubmissionsQueryParam;
import com.wcfvol.oj.mis.pojo.po.SubmitPo;
import com.wcfvol.oj.mis.service.ProblemService;
import com.wcfvol.oj.mis.service.SubmissionService;
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
    public List<Submission> getSubmissionsByParam(SubmissionsQueryParam param) {
        return submissionDAO.getSubmissionsByParam(param);
    }

//    @Override
//    public List<Submission> getSubmissionList(int start, int size) {
////        return submissionDAO.getSubmissionList(start,size);
//    }

    @Override
    public Submission getSubmissionById(int id) {
        return submissionDAO.getSubmissionById(id);
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
    public SubmitPo getSubmitPojoBySubmission(Submission submission) {
        SubmitPo submitPo = new SubmitPo();
        submitPo.setLanguage(submission.getLanguage());
        submitPo.setUsername(submission.getUsername());
        submitPo.setProblemId(submission.getProblemId());
        submitPo.setCode(submission.getCode());
        Problem problem =  problemService.getProblemById(submission.getProblemId());
        submitPo.setMemLimit(problem.getMemLimit());
        submitPo.setTimeLimit(problem.getTimeLimit());
        submitPo.setMemLimit(problem.getMemLimit());
        submitPo.setTestCase(problem.getTestCase());
        submitPo.setId(submission.getId());
        return submitPo;
    }
}
