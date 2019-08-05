package com.wcfvol.oj.mis.controller.filterapi;

import com.wcfvol.oj.mis.pojo.data.Submission;
import com.wcfvol.oj.mis.pojo.data.User;
import com.wcfvol.oj.mis.client.SendCode;
import com.wcfvol.oj.mis.pojo.RestResult;
import com.wcfvol.oj.mis.pojo.po.SubmitPo;
import com.wcfvol.oj.mis.pojo.po.TaskPo;
import com.wcfvol.oj.mis.service.ProblemService;
import com.wcfvol.oj.mis.service.SubmissionService;
import com.wcfvol.oj.mis.service.UserService;
import com.wcfvol.oj.mis.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
