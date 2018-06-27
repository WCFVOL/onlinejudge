package com.wcfvol.onlinejudge.controller;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.entity.Authenticate;
import com.wcfvol.onlinejudge.entity.User;
import com.wcfvol.onlinejudge.service.AuthService;
import com.wcfvol.onlinejudge.service.UserService;
import com.wcfvol.onlinejudge.util.JwtUtil;
import com.wcfvol.onlinejudge.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * @author Wang Chunfei
 */
@Controller
@RequestMapping(value = "/api")
public class AccountController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String register(@RequestBody String body
                           ) {
        JSONObject jsonResult = new JSONObject();
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        String username = jsonBody.getString("username");
        String checkPassword = jsonBody.getString("checkPassword");
        String password = jsonBody.getString("password");
        String email = jsonBody.getString("email");
        if (!password.equals(checkPassword)) {
            jsonResult.put("ok",0);
            jsonResult.put("msg","Two password is different");
            return jsonResult.toJSONString();
        }
        String salt=UUID.randomUUID().toString();
        String newPassword=MD5.toMD5(password+salt);
        Authenticate authenticate= new Authenticate();
        authenticate.setPassword(newPassword);
        authenticate.setSalt(salt);
        authenticate.setUsername(username);
        if (authService.saveAuth(authenticate)){
            jsonResult.put("ok",1);
            User user=new User();
            user.setUsername(username);
            user.setEmail(email);
            userService.addUser(user);
            // 注册自动登陆但是不给token
            jsonResult.put("data",JSONObject.toJSON(userService.getUser(username)));
        }
        else {
            jsonResult.put("ok",0);
            jsonResult.put("msg","Account has already existed!");
        }
        return jsonResult.toJSONString();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody String body, HttpServletResponse response) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        JSONObject jsonResult = new JSONObject();
        String username = jsonBody.getString("username");
        String password = jsonBody.getString("password");
        boolean isRemember = jsonBody.getBoolean("isRemember");
        List<Authenticate> authList = authService.getAuth(username);
        if (authList.isEmpty()) {
            jsonResult.put("ok",0);
            jsonResult.put("msg","account does not exit");
            return jsonResult.toJSONString();
        }
        Authenticate auth = authList.get(0);
        String newPassword = MD5.toMD5(password+auth.getSalt());
        if (newPassword.equals(auth.getPassword())) {
            jsonResult.put("ok",1);
            if(isRemember) {
                //默认记住7+3天
                String jwt = JwtUtil.generateToken(username, 60L * 24 * 10);
                Cookie cookie = new Cookie("token",jwt);
                cookie.setMaxAge(60*60*24*7);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            jsonResult.put("data",userService.getUser(username));
        }
        else {
            jsonResult.put("ok",0);
            jsonResult.put("msg","password is not correct");
        }
        return jsonResult.toJSONString();
    }

}
