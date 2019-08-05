package com.wcfvol.oj.mis.service;

import com.wcfvol.oj.mis.pojo.data.ProblemList;

import java.util.List;

public interface ProblemListService {
    void addProblemList(ProblemList problemList);
    List<ProblemList> getAllProblemList();
    List<ProblemList> getProblemListByLimit(int start,int size);
}
