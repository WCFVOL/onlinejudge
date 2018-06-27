package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.po.Problem;

public interface ProblemService {
    void addProblem(Problem problem);
    Problem getProblemById(int id);
}
