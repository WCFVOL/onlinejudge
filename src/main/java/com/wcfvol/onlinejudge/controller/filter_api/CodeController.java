package com.wcfvol.onlinejudge.controller.filter_api;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.entity.User;
import com.wcfvol.onlinejudge.kafka.SendCode;
import com.wcfvol.onlinejudge.service.SubmissionService;
import com.wcfvol.onlinejudge.service.UserService;
import com.wcfvol.onlinejudge.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;

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
    public String submitCode(@RequestBody String body) throws ExecutionException, InterruptedException {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        JSONObject jsonResult = new JSONObject();
        Submission submission = new Submission();
        submission.setCode(jsonBody.getString("code"));
        submission.setDate(jsonBody.getDate("date"));
        submission.setProblemId(jsonBody.getInteger("problem_id"));
        submission.setUserId(jsonBody.getInteger("user_id"));
        submission.setLanguage(jsonBody.getInteger("language"));
        submissionService.addSubmission(submission);
        sendCode.send("test",submission.toSubmitString());
        jsonResult.put("ok",1);
        return jsonResult.toJSONString();
    }

    @RequestMapping(value = "/code/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getCode(HttpServletRequest request, @PathVariable("id") int id) {
        Cookie[] cookies = request.getCookies();
        JSONObject jsonResult = new JSONObject();
        String token = cookies[cookies.length-1].getValue();
        String username = JwtUtil.getUsernameFromToken(token);
        User user = userService.getUser(username);
        Submission sub=submissionService.getCodeByid(id);
        if (sub.getUserId() != user.getId()) {
            jsonResult.put("ok",0);
            jsonResult.put("msg","没有权限!");
        } else {
          jsonResult.put("ok",1);
          jsonResult.put("code",sub.getCode());
        }
        return jsonResult.toJSONString();
    }
}
