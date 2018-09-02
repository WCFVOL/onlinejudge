package com.wcfvol.onlinejudge.controller.filterapi;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.entity.User;
import com.wcfvol.onlinejudge.kafka.SendCode;
import com.wcfvol.onlinejudge.po.RestResult;
import com.wcfvol.onlinejudge.po.SubmitPojo;
import com.wcfvol.onlinejudge.po.TaskPojo;
import com.wcfvol.onlinejudge.service.SubmissionService;
import com.wcfvol.onlinejudge.service.UserService;
import com.wcfvol.onlinejudge.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public RestResult submitCode(HttpServletRequest request, @RequestBody String body) throws ExecutionException, InterruptedException, URISyntaxException {
        System.out.println(body);
        Cookie[] cookies = request.getCookies();
        String token = cookies[cookies.length-1].getValue();
        String username = JwtUtil.getUsernameFromToken(token);
        userService.addAttempt(username);
        Submission submission = submissionService.getSubmissionByBody(body);
        submissionService.addSubmission(submission);
        SubmitPojo submitPojo = submissionService.getSubmitPojoBysubmission(submission);
        TaskPojo task = new TaskPojo();
        task.setData(submitPojo.toString());
        task.setTaskId(1);
        System.out.println(task.toString());
        sendCode.send(task.toString());
        return RestResult.ok().setData(submission);
    }

    @RequestMapping(value = "/code/{id}",method = RequestMethod.GET)
    @ResponseBody
    public RestResult getCode(HttpServletRequest request, @PathVariable("id") int id) {
        Cookie[] cookies = request.getCookies();
        String token = cookies[cookies.length-1].getValue();
        String username = JwtUtil.getUsernameFromToken(token);
        User user = userService.getUser(username);
        Submission sub=submissionService.getCodeByid(id);
        if (sub.getUsername() != user.getUsername()) {
            return RestResult.fail(0,"没有权限!");
        }
        return RestResult.ok().setData(sub.getCode());
    }
}
