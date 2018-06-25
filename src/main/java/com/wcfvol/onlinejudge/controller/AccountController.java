package com.wcfvol.onlinejudge.controller;

import com.wcfvol.onlinejudge.po.Authenticate;
import com.wcfvol.onlinejudge.po.User;
import com.wcfvol.onlinejudge.service.AuthService;
import com.wcfvol.onlinejudge.service.UserService;
import com.wcfvol.onlinejudge.util.JwtUtil;
import com.wcfvol.onlinejudge.util.MD5;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String register(@RequestBody String body
                           ) {

        JSONObject jsonpObject = new JSONObject();
        JSONObject jsonBody = new JSONObject(body);
        String username = jsonBody.getString("username");
        String checkPassword = jsonBody.getString("checkPassword");
        String password = jsonBody.getString("password");
        String email = jsonBody.getString("email");
        if (!password.equals(checkPassword)) {
            jsonpObject.put("ok",0);
            jsonpObject.put("msg","Two password is different");
            return jsonpObject.toString();
        }
        String salt=UUID.randomUUID().toString();
        String newPassword=MD5.toMD5(password+salt);
        Authenticate authenticate= new Authenticate();
        authenticate.setPassword(newPassword);
        authenticate.setSalt(salt);
        authenticate.setUsername(username);
        if (authService.saveAuth(authenticate)){
            jsonpObject.put("ok",1);
            User user=new User();
            user.setUsername(username);
            user.setEmail(email);
            userService.addUser(user);
        }
        else {
            jsonpObject.put("ok",0);
            jsonpObject.put("msg","Account has already existed!");
        }
        return jsonpObject.toString();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody String body) {
        JSONObject jsonBody = new JSONObject(body);
        JSONObject jsonResult = new JSONObject();
        String username = jsonBody.getString("username");
        String password = jsonBody.getString("password");
        List<Authenticate> authList = authService.getAuth(username);
        if (authList.isEmpty()) {
            jsonResult.put("ok",0);
            jsonResult.put("msg","account does not exit");
            return jsonResult.toString();
        }
        Authenticate auth = authList.get(0);
        String newPassword = MD5.toMD5(password+auth.getSalt());
        if (newPassword.equals(auth.getPassword())) {
            jsonResult.put("ok",1);
            String jwt = JwtUtil.generateToken(username,60L*24*7);
            jsonResult.put("token",jwt);
            jsonResult.put("data",userService.getUser(username));
        }
        else {
            jsonResult.put("ok",0);
            jsonResult.put("msg","password is not correct");
        }
        return jsonResult.toString();
    }

    @RequestMapping(value = "/loginbycookie",method = RequestMethod.POST)
    @ResponseBody
    public String loginByCookie(@RequestBody String body) {

        return null;
    }

}
