package com.wcfvol.onlinejudge.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ResultController
 * @Author Wang Chunfei
 * @Date 2018/7/1 下午4:00
 **/
@Controller
@RequestMapping(value = "/admin")
public class ResultController {
    @Autowired
    SubmissionService submissionService;

    @RequestMapping(value = "/set_result",method = RequestMethod.POST)
    @ResponseBody
    public String setResult(@RequestBody String body) {
        JSONObject jsonResult = new JSONObject();
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        Submission submission = new Submission();
        submission.setId(jsonBody.getInteger("Id"));
        submission.setLength(jsonBody.getInteger("Length"));
        submission.setMemory(jsonBody.getInteger("Memory"));
        submission.setTime(jsonBody.getDouble("Time"));
        submission.setResult(jsonBody.getInteger("Result"));
        submissionService.updateResult(submission);
        jsonResult.put("ok",1);
        return jsonResult.toJSONString();
    }

}
