package com.wcfvol.oj.mis.service.impl;

import com.wcfvol.oj.mis.mapper.dao.ProblemListDAO;
import com.wcfvol.oj.mis.pojo.data.ProblemList;
import com.wcfvol.oj.mis.service.ProblemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProblemListServiceImpl implements ProblemListService {

    @Autowired
    private ProblemListDAO problemListDAO;

    @Override
    public void addProblemList(ProblemList problemList) {
        problemListDAO.addProblemList(problemList);
    }

    @Override
    public List<ProblemList> getAllProblemList() {
        return problemListDAO.getAllProblemList();
    }

    @Override
    public List<ProblemList> getProblemListByLimit(int start, int size) {
        return problemListDAO.getProblemListByLimit(start,size);
    }
}
