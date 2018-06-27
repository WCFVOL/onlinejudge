package com.wcfvol.onlinejudge.service.impl;

import com.wcfvol.onlinejudge.dao.ProblemDAO;
import com.wcfvol.onlinejudge.po.Problem;
import com.wcfvol.onlinejudge.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemDAO problemDAO;

    @Override
    public void addProblem(Problem problem) {
        problemDAO.addProblem(problem);
    }

    @Override
    public Problem getProblemById(int id) {
        return problemDAO.getProblemById(id);
    }
}
