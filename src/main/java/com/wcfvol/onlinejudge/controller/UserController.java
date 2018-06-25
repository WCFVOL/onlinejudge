package com.wcfvol.onlinejudge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/filter_api")
public class UserController {
    @RequestMapping(value = "/loginbycookie",method = RequestMethod.POST)
    @ResponseBody
    public String loginByCookie(@RequestBody String body) {

        return null;
    }
}
