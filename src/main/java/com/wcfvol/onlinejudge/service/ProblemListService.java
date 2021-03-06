package com.wcfvol.onlinejudge.service;

import com.wcfvol.onlinejudge.pojo.data.ProblemList;

import java.util.List;

public interface ProblemListService {
    void addProblemList(ProblemList problemList);
    List<ProblemList> getAllProblemList();
    List<ProblemList> getProblemListByLimit(int start,int size);
}
