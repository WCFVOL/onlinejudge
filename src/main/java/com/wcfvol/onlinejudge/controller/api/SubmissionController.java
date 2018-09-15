package com.wcfvol.onlinejudge.controller.api;

import com.wcfvol.onlinejudge.pojo.RestResult;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
// TODO: 2018/6/27 TEST
public class SubmissionController {
    @Autowired
    SubmissionService submissionService;

    @RequestMapping(value = "/submissions",method = RequestMethod.GET)
    public RestResult getAllSubmissions() {
        return RestResult.ok().setData(submissionService.getAllSubmission());
    }

}
