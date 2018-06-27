package com.wcfvol.onlinejudge.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.service.ProblemListService;
import com.wcfvol.onlinejudge.service.ProblemService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
public class ProblemController {
    @Autowired
    private ProblemListService problemListService;

    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = "/problem_list",method = RequestMethod.POST)
    @ResponseBody
    public String getProblemList(@RequestBody String body){
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        JSONObject jsonResult = new JSONObject();
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
            jsonResult.put("data",problemListService.getAllProblemList());
        }
        else {
            jsonResult.put("data",problemListService.getProblemListByLimit(start,size));
        }
        return jsonResult.toJSONString();
    }

    @RequestMapping(value = "/problem",method = RequestMethod.POST)
    @ResponseBody
    public String getProblem(@RequestBody String body) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        JSONObject jsonResult = new JSONObject();
        String sId = jsonBody.getString("id");
        int id = Integer.parseInt(sId);
        jsonResult.put("ok","1");
        jsonResult.put("problem",problemService.getProblemById(id));
        return jsonResult.toJSONString();
    }
}
