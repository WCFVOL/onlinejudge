package com.wcfvol.oj.mis.controller.api;

import com.github.pagehelper.Page;
import com.wcfvol.oj.mis.pojo.RestResult;
import com.wcfvol.oj.mis.pojo.params.SubmissionsQueryParam;
import com.wcfvol.oj.mis.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
// TODO: 2018/6/27 TEST
public class SubmissionController {
    @Autowired
    SubmissionService submissionService;

    @RequestMapping(value = "/submissions",method = RequestMethod.POST)
    public RestResult getAllSubmissions(@RequestBody SubmissionsQueryParam param) {
        Page page = (Page)submissionService.getSubmissionsByParam(param);
        return RestResult.ok().setTotal(page.getTotal()).setData(page.getResult());
    }

}
