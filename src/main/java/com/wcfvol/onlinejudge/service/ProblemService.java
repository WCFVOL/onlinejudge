package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.pojo.data.Problem;

public interface ProblemService {
    void addProblem(Problem problem);
    Problem getProblemById(int id);
    void updateCaseId(int id,int num);
    void addSubmitNum(int id);
    void addAcceptNum(int id);
}
