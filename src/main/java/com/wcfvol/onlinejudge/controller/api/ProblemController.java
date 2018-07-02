package com.wcfvol.onlinejudge.controller.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.po.RestResult;
import com.wcfvol.onlinejudge.service.ProblemListService;
import com.wcfvol.onlinejudge.service.ProblemService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ProblemController {
    @Autowired
    private ProblemListService problemListService;

    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = "/problem_list",method = RequestMethod.POST)
    public RestResult getProblemList(@RequestBody String body){
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        int start=0,size=-1;
        String startbody=jsonBody.getString("start");
        if (startbody!=null) {
            start=Integer.parseInt(startbody);
        }
        String sizebody=jsonBody.getString("size");
        if (startbody!=null) {
            size=Integer.parseInt(sizebody);
        }
        if (size==-1) {
            return RestResult.ok().setData(problemListService.getAllProblemList());
        }
        else {
            return RestResult.ok().setData(problemListService.getProblemListByLimit(start,size));
        }
    }

    @RequestMapping(value = "/problem",method = RequestMethod.POST)
    public RestResult getProblem(@RequestBody String body) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        String sId = jsonBody.getString("id");
        int id = Integer.parseInt(sId);
        return RestResult.ok().setData(problemService.getProblemById(id));
    }
}
