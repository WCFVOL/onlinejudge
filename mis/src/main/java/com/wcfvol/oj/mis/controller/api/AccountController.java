package com.wcfvol.oj.mis.controller.api;

import com.wcfvol.oj.mis.pojo.data.Authenticate;
import com.wcfvol.oj.mis.pojo.data.User;
import com.wcfvol.oj.mis.pojo.RestResult;
import com.wcfvol.oj.mis.pojo.params.LoginParam;
import com.wcfvol.oj.mis.pojo.params.RegisterParam;
import com.wcfvol.oj.mis.service.AuthService;
import com.wcfvol.oj.mis.service.UserService;
import com.wcfvol.oj.mis.util.JwtUtil;
import com.wcfvol.oj.mis.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public RestResult register(@RequestBody RegisterParam param
                           ) {
        if (!param.getPassword().equals(param.getCheckPassword())) {
            return RestResult.fail(0,"Two password is different");
        }
        String salt=UUID.randomUUID().toString();
        String newPassword=MD5.toMD5(param.getPassword()+salt);
        Authenticate authenticate= new Authenticate();
        authenticate.setPassword(newPassword);
        authenticate.setSalt(salt);
        authenticate.setUsername(param.getUsername());
        if (authService.saveAuth(authenticate)){
            User user=new User();
            user.setUsername(param.getUsername());
            user.setEmail(param.getEmail());
            userService.addUser(user);
            // 注册自动登陆但是不给token
            // jsonResult.put("data",JSONObject.toJSON(userService.getUser(username)));
        }
        else {
            return RestResult.fail(0,"Account has already existed!");
        }
        return RestResult.ok().setData(userService.getUser(param.getUsername()));
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public RestResult login(@RequestBody LoginParam param, HttpServletResponse response) {
        List<Authenticate> authList = authService.getAuth(param.getUsername());
        if (authList.isEmpty()) {
            return RestResult.fail(0,"account does not exit");
        }
        Authenticate auth = authList.get(0);
        String newPassword = MD5.toMD5(param.getPassword()+auth.getSalt());
        if (newPassword.equals(auth.getPassword())) {
            String jwt;
            if(param.getIsRemember()) {
                //默认记住7+3天
                jwt = JwtUtil.generateToken(param.getUsername(), 60L * 24 * 7);
            } else {
                jwt = JwtUtil.generateToken(param.getUsername(), 60L * 24);
            }
            Cookie cookie = new Cookie("token",jwt);
            cookie.setMaxAge(60*60*24*7);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        else {
            return RestResult.fail(0,"password is not correct");
        }
        return RestResult.ok().setData(userService.getUser(param.getUsername()));
    }

}
