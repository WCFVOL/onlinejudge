package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.pojo.po.gen.Problem;

public interface ProblemService {
    void addProblem(Problem problem);
    Problem getProblemById(int id);
    void updateCaseId(int id,int num);
}
