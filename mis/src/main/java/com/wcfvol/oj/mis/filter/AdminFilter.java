package com.wcfvol.oj.mis.filter;

import com.wcfvol.oj.mis.pojo.data.User;
import com.wcfvol.oj.mis.service.UserService;
import com.wcfvol.oj.mis.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Autowired
    UserService userService;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies!=null&&cookies.length>0) {
                String token = cookies[cookies.length - 1].getValue();
                // 检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
                JwtUtil.validateToken(token);
                String username=JwtUtil.getUsernameFromToken(token);
                User user = userService.getUser(username);
                if (user.getIsAdmin()==0) {
                    throw new Exception("not admin");
                }
            } else {
                String value="isAdmin";
                String token = request.getHeader("token");
                System.out.println(token);
                if (!value.equals(token))  {
                    throw new Exception("not admin");
                }
            }

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
