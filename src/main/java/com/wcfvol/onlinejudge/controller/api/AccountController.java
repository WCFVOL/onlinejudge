package com.wcfvol.onlinejudge.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.entity.Authenticate;
import com.wcfvol.onlinejudge.entity.User;
import com.wcfvol.onlinejudge.po.RestResult;
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
    public RestResult register(@RequestBody String body
                           ) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        String username = jsonBody.getString("username");
        String checkPassword = jsonBody.getString("checkPassword");
        String password = jsonBody.getString("password");
        String email = jsonBody.getString("email");
        if (!password.equals(checkPassword)) {
            return RestResult.fail(0,"Two password is different");
        }
        String salt=UUID.randomUUID().toString();
        String newPassword=MD5.toMD5(password+salt);
        Authenticate authenticate= new Authenticate();
        authenticate.setPassword(newPassword);
        authenticate.setSalt(salt);
        authenticate.setUsername(username);
        if (authService.saveAuth(authenticate)){
            User user=new User();
            user.setUsername(username);
            user.setEmail(email);
            userService.addUser(user);
            // 注册自动登陆但是不给token
            // jsonResult.put("data",JSONObject.toJSON(userService.getUser(username)));
        }
        else {
            return RestResult.fail(0,"Account has already existed!");

        }
        return RestResult.ok().setData(userService.getUser(username));
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public RestResult login(@RequestBody String body, HttpServletResponse response) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        String username = jsonBody.getString("username");
        String password = jsonBody.getString("password");
        boolean isRemember = jsonBody.getBoolean("isRemember");
        List<Authenticate> authList = authService.getAuth(username);
        if (authList.isEmpty()) {
            return RestResult.fail(0,"account does not exit");
        }
        Authenticate auth = authList.get(0);
        String newPassword = MD5.toMD5(password+auth.getSalt());
        if (newPassword.equals(auth.getPassword())) {
            if(isRemember) {
                //默认记住7+3天
                String jwt = JwtUtil.generateToken(username, 60L * 24 * 10);
                Cookie cookie = new Cookie("token",jwt);
                cookie.setMaxAge(60*60*24*7);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        else {
            return RestResult.fail(0,"password is not correct");
        }
        return RestResult.ok().setData(userService.getUser(username));
    }

}
