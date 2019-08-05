package com.wcfvol.oj.mis.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.oj.mis.pojo.RestResult;
import com.wcfvol.oj.mis.service.ProblemListService;
import com.wcfvol.oj.mis.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/problem",method = RequestMethod.GET)
    public RestResult getProblem(@RequestParam Integer id) {
        return RestResult.ok().setData(problemService.getProblemById(id));
    }
}
