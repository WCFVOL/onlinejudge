package com.wcfvol.onlinejudge.service.impl;

import com.wcfvol.onlinejudge.entity.Problem;
import com.wcfvol.onlinejudge.service.ProblemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProblemServiceImplTest {

    @Autowired
    ProblemService problemService;

    @Test
    public void addProblem() {
        Problem problem = new Problem();
        problem.setInput("1");
        problem.setDescription("1");
        problem.setTitle("1");
        problem.setOutput("1");
        problemService.addProblem(problem);
    }

    @Test
    public void getProblemById() {
        Problem problem=problemService.getProblemById(1);
        System.out.println(problem);
    }
}