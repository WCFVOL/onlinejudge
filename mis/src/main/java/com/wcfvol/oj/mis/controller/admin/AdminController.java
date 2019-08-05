package com.wcfvol.oj.mis.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.oj.mis.pojo.data.*;
import com.wcfvol.oj.mis.client.SendCode;
import com.wcfvol.oj.mis.pojo.RestResult;
import com.wcfvol.oj.mis.pojo.params.AddProblemParam;
import com.wcfvol.oj.mis.pojo.po.TaskPo;
import com.wcfvol.oj.mis.service.*;
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
    UserService userService;
    @Autowired
    SendCode sendCode;

    @Autowired
    AnnouncementsService announcementsService;
    @RequestMapping(value = "/add_announcement",method = RequestMethod.POST)
    @ResponseBody
    public RestResult addAnnouncement(@RequestBody Announcements announcements) {
        announcementsService.addAnnouncements(announcements);
        return RestResult.ok();
    }

    @RequestMapping(value = "/set_result", method = RequestMethod.POST)
    public RestResult setResult(@RequestBody String body) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        Submission submission = new Submission();
        submission.setId(jsonBody.getInteger("Id"));
        submission.setLength(jsonBody.getInteger("Length"));
        submission.setMemory(jsonBody.getInteger("Memory"));
        submission.setTime(jsonBody.getDouble("Time"));
        submission.setResult(jsonBody.getInteger("Result"));
        submissionService.updateResult(submission);
        if (submission.getResult().equals(0)) {
            User user = userService.getUserBySubmissionId(submission.getId());
            userService.addSolved(user.getUsername());
            problemService.addAcceptNum(submissionService.getSubmissionById(submission.getId()).getProblemId());
            return RestResult.ok();
        }
        return RestResult.ok();
    }

    @RequestMapping(value = "/add_problem", method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    public RestResult addProblem(@RequestBody AddProblemParam param) {
        Problem problem = new Problem();
        problem.setDescription(param.getDescription());
        problem.setInput(param.getInput());
        problem.setOutput(param.getOutput());
        problem.setTitle(param.getTitle());
        problem.setHint(param.getHint());
        problem.setSampleInput(param.getSampleInput());
        problem.setSampleOutput(param.getSampleOutput());
        problem.setTimeLimit(param.getTimeLimit());
        problem.setMemLimit(param.getMemLimit());
        problemService.addProblem(problem);
        ProblemList problemList = new ProblemList();
        problemList.setAuthor(param.getAuthor());
        problemList.setSource(param.getSource());
        problemList.setTitle(param.getTitle());
        problemList.setProblemId(problem.getId());
        problemListService.addProblemList(problemList);
        return RestResult.ok();
    }

    @RequestMapping(value = "/add_input", method = RequestMethod.POST)
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public RestResult addInput(@RequestParam("file") MultipartFile input, @RequestParam("id") int id) throws ExecutionException, InterruptedException, IOException, URISyntaxException {
        TaskPo task = new TaskPo();
        task.setTaskId(2);
        JSONObject json = new JSONObject();
        json.put("input", new String(input.getBytes()));
        json.put("problemId", id);
        synchronized (problemService) {
            Problem problem = problemService.getProblemById(id);
            problemService.updateCaseId(problem.getId(), 1);
            json.put("caseId", problem.getTestCase() % 10000);
        }
        task.setData(json.toJSONString());
        sendCode.send(task.toString());
        return RestResult.ok();
    }

    @RequestMapping(value = "/add_output", method = RequestMethod.POST)
    public RestResult addOutput(@RequestParam("file") MultipartFile output, @RequestParam("id") int id) throws IOException {
        TaskPo task = new TaskPo();
        task.setTaskId(2);
        JSONObject json = new JSONObject();
        json.put("output", new String(output.getBytes()));
        json.put("problemId", id);
        synchronized (problemService) {
            Problem problem = problemService.getProblemById(id);
            problemService.updateCaseId(problem.getId(), 10000);
            json.put("caseId", problem.getTestCase() / 10000);
        }
        task.setData(json.toJSONString());
        sendCode.send(task.toString());
        return RestResult.ok();
    }

    @RequestMapping(value = "/add_contest", method = RequestMethod.POST)
    public RestResult addContest(@RequestBody Contest contest) {
        return RestResult.ok();
    }
}
