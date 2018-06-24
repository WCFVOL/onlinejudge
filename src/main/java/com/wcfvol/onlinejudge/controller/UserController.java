package com.wcfvol.onlinejudge.controller;

import com.wcfvol.onlinejudge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wang Chunfei
 */
@Controller
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    private UserService userService;
}
