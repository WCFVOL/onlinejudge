package com.wcfvol.onlinejudge.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/api")
@Controller
// TODO: 2018/6/27 TEST
public class SubmissionController {
    @Autowired
    SubmissionService submissionService;

    @RequestMapping(value = "/submissions",method = RequestMethod.GET)
    @ResponseBody
    public String getAllSubmissions() {
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("ok",1);
        jsonResult.put("data",submissionService.getAllSubmission());
        return jsonResult.toJSONString();
    }

}
