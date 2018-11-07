package com.wcfvol.onlinejudge.controller.filterapi;

import com.wcfvol.onlinejudge.pojo.data.Submission;
import com.wcfvol.onlinejudge.pojo.data.User;
import com.wcfvol.onlinejudge.client.SendCode;
import com.wcfvol.onlinejudge.pojo.RestResult;
import com.wcfvol.onlinejudge.pojo.po.SubmitPo;
import com.wcfvol.onlinejudge.pojo.po.TaskPo;
import com.wcfvol.onlinejudge.service.ProblemService;
import com.wcfvol.onlinejudge.service.SubmissionService;
import com.wcfvol.onlinejudge.service.UserService;
import com.wcfvol.onlinejudge.util.JwtUtil;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

/**
 * @author Wang Chunfei
 */
@Controller
@RequestMapping(value = "/filter_api")
public class CodeController {
    @Autowired
    SubmissionService submissionService;
    @Autowired
    UserService userService;
    @Autowired
    SendCode sendCode;
    @Autowired
    ProblemService problemService;

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public RestResult submitCode(HttpServletRequest request, @RequestBody String body) {
        Cookie[] cookies = request.getCookies();
        String token = cookies[cookies.length - 1].getValue();
        String username = JwtUtil.getUsernameFromToken(token);
        Submission submission = submissionService.getSubmissionByBody(body);
        submissionService.addSubmission(submission);
        SubmitPo submitPo = submissionService.getSubmitPojoBySubmission(submission);
        TaskPo task = new TaskPo();
        task.setData(submitPo.toString());
        task.setTaskId(1);
        if (sendCode.send(task.toString())) {
            userService.addAttempt(username);
            problemService.addSubmitNum(submission.getProblemId());
            return RestResult.ok().setData(submission);
        }
        submission.setResult(5);
        submissionService.updateResult(submission);
        return RestResult.fail(0, "提交评测失败");
    }

    @RequestMapping(value = "/code/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResult getCode(HttpServletRequest request, @PathVariable("id") int id) {
        Cookie[] cookies = request.getCookies();
        String token = cookies[cookies.length - 1].getValue();
        String username = JwtUtil.getUsernameFromToken(token);
        User user = userService.getUser(username);
        Submission sub = submissionService.getSubmissionById(id);
        if (!sub.getUsername().equals(user.getUsername())) {
            return RestResult.fail(0, "没有权限!");
        }
        return RestResult.ok().setData(sub.getCode());
    }
}
