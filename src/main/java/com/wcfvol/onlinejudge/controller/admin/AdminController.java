package com.wcfvol.onlinejudge.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.pojo.po.gen.Problem;
import com.wcfvol.onlinejudge.pojo.po.gen.ProblemList;
import com.wcfvol.onlinejudge.pojo.po.gen.Submission;
import com.wcfvol.onlinejudge.client.SendCode;
import com.wcfvol.onlinejudge.pojo.RestResult;
import com.wcfvol.onlinejudge.pojo.po.TaskPo;
import com.wcfvol.onlinejudge.service.ProblemListService;
import com.wcfvol.onlinejudge.service.ProblemService;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName ResultController
 * @Author Wang Chunfei
 * @Date 2018/7/1 下午4:00
 **/
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    SubmissionService submissionService;
    @Autowired
    ProblemService problemService;
    @Autowired
    ProblemListService problemListService;
    @Autowired
    SendCode sendCode;


    @RequestMapping(value = "/set_result",method = RequestMethod.POST)
    public RestResult setResult(@RequestBody String body) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        Submission submission = new Submission();
        submission.setId(jsonBody.getInteger("Id"));
        submission.setLength(jsonBody.getInteger("Length"));
        submission.setMemory(jsonBody.getInteger("Memory"));
        submission.setTime(jsonBody.getDouble("Time"));
        submission.setResult(jsonBody.getInteger("Result"));
        submissionService.updateResult(submission);
        return RestResult.ok();
    }

    @RequestMapping(value = "/add_problem",method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    public RestResult addProblem(@RequestBody String body) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        Problem problem = new Problem();
        problem.setDescription(jsonBody.getString("description"));
        problem.setInput(jsonBody.getString("input"));
        problem.setOutput(jsonBody.getString("output"));
        problem.setTitle(jsonBody.getString("title"));
        problem.setHint(jsonBody.getString("hint"));
        problem.setSampleInput(jsonBody.getString("sampleInput"));
        problem.setSampleOutput(jsonBody.getString("sampleOutput"));
        problem.setTimeLimit(jsonBody.getInteger("timeLimit"));
        problem.setMemLimit(jsonBody.getInteger("memLimit"));
        System.out.println(problem);
        ProblemList problemList = new ProblemList();
        problemList.setAuthor(jsonBody.getString("author"));
        problemList.setSource(jsonBody.getString("source"));
        problemList.setTitle(jsonBody.getString("title"));
        problemService.addProblem(problem);
        problemList.setProblemId(problem.getId());
        problemListService.addProblemList(problemList);
        return RestResult.ok();
    }

    @RequestMapping(value = "/add_input",method = RequestMethod.POST)
    @Transactional(isolation=Isolation.SERIALIZABLE)
    public RestResult addInput(@RequestParam("file")MultipartFile input, @RequestParam("id") int id) throws ExecutionException, InterruptedException, IOException, URISyntaxException {
        // TODO: 2018/7/12 CASE ID
        System.out.println(123);
        TaskPo task = new TaskPo();
        task.setTaskId(2);
        JSONObject json = new JSONObject();
        json.put("input",new String(input.getBytes()));
        json.put("problemId",id);
        synchronized(problemService) {
            Problem problem = problemService.getProblemById(id);
            problemService.updateCaseId(problem.getId(),1);
            json.put("caseId", problem.getTestCase()%10000);
        }
        task.setData(json.toJSONString());
        System.out.println(task.toString());
        sendCode.send(task.toString());
        return RestResult.ok();
    }
    @RequestMapping(value = "/add_output",method = RequestMethod.POST)
    public RestResult addOutput(@RequestParam("file")MultipartFile output, @RequestParam("id") int id) throws ExecutionException, InterruptedException, IOException, URISyntaxException {
        // TODO: 2018/7/2
        System.out.println(123);
        TaskPo task = new TaskPo();
        task.setTaskId(2);
        JSONObject json = new JSONObject();
        json.put("output",new String(output.getBytes()));
        json.put("problemId",id);
        synchronized(problemService) {
            Problem problem = problemService.getProblemById(id);
            problemService.updateCaseId(problem.getId(),10000);
            json.put("caseId", problem.getTestCase()/10000);
        }
        task.setData(json.toJSONString());
        System.out.println(task.toString());
        sendCode.send(task.toString());
        return RestResult.ok();
    }

}
