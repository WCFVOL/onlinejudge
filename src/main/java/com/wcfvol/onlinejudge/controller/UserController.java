package com.wcfvol.onlinejudge.controller;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.po.User;
import com.wcfvol.onlinejudge.service.UserService;
import com.wcfvol.onlinejudge.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/filter_api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginbycookie",method = RequestMethod.GET)
    @ResponseBody
    public String loginByCookie(@RequestHeader("Authorization") String authorization) {
        JSONObject jsonResult = new JSONObject();
        String username = JwtUtil.getUsernameFromToken(authorization);
        User user = userService.getUser(username);
        jsonResult.put("ok",1);
        jsonResult.put("data",user);
        return jsonResult.toJSONString();
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    @ResponseBody
    public String profile(@RequestHeader("Cookie") String cookie) {
        return "ok";
    }
}
