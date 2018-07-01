package com.wcfvol.onlinejudge.controller.filter_api;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.kafka.SendCode;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping(value = "/filter_api")
public class SubmitController {
    @Autowired
    SubmissionService submissionService;

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

}
