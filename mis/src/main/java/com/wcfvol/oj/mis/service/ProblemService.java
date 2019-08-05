package com.wcfvol.oj.mis.service;

import com.wcfvol.oj.mis.pojo.data.Problem;

public interface ProblemService {
    void addProblem(Problem problem);
    Problem getProblemById(int id);
    void updateCaseId(int id,int num);
    void addSubmitNum(int id);
    void addAcceptNum(int id);
}
