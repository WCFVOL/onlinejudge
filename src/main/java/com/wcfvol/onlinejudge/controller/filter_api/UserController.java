package com.wcfvol.onlinejudge.controller.filter_api;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.entity.User;
import com.wcfvol.onlinejudge.service.UserService;
import com.wcfvol.onlinejudge.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
    public String profile(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        JSONObject jsonResult = new JSONObject();
        String token = cookies[cookies.length-1].getValue();
        String username = JwtUtil.getUsernameFromToken(token);
        User user = userService.getUser(username);
        jsonResult.put("ok",1);
        jsonResult.put("data",user);
        return jsonResult.toJSONString();
    }
}
