package com.wcfvol.onlinejudge.controller.filterapi;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.entity.User;
import com.wcfvol.onlinejudge.kafka.SendCode;
import com.wcfvol.onlinejudge.po.RestResult;
import com.wcfvol.onlinejudge.service.SubmissionService;
import com.wcfvol.onlinejudge.service.UserService;
import com.wcfvol.onlinejudge.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
    public RestResult submitCode(@RequestBody String body) throws ExecutionException, InterruptedException {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        System.out.println(body);
        Submission submission = new Submission();
        submission.setCode(jsonBody.getString("code"));
        submission.setDate(jsonBody.getDate("date"));
        submission.setProblemId(jsonBody.getInteger("problem_id"));
        submission.setUserId(jsonBody.getInteger("user_id"));
        submission.setLanguage(jsonBody.getInteger("language"));
        submissionService.addSubmission(submission);
        sendCode.send("test",submission.toSubmitString());
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
        if (sub.getUserId() != user.getId()) {
            return RestResult.fail(0,"没有权限!");
        }
        return RestResult.ok().setData(sub.getCode());
    }
}
