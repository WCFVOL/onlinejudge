package com.wcfvol.oj.permit.aop;

import com.wcfvol.oj.permit.annotation.Authority;
import com.wcfvol.oj.permit.enums.Role;
import com.wcfvol.oj.permit.util.JwtUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author wangchunfei
 * @description
 * @date 2019-08-01 19:14
 */
@Aspect
@Component
public class AuthCheck {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.wcfvol.oj.permit.annotation.Authority)")
    public void authCheckPointcut() {
    }

    @Before("authCheckPointcut()")
    public void checkAuth(JoinPoint joinPoint) {
        Role role = getRolesByJoinPoint(joinPoint);
        if (role == null) {
            return;
        }
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Cookie[] cookies = request.getCookies();
        String token = null;
        for (Cookie cookie : cookies) {
            if (Objects.equals(cookie.getName(),"token")) {
                token = cookie.getValue();
                break;
            }
        }
        String username = JwtUtil.getUsernameFromToken(token);


    }

    private Role getRolesByJoinPoint(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Class<?>[] argTypes = new Class[joinPoint.getArgs().length];
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();
        }
        Method method = null;
        try {
            method = joinPoint.getTarget().getClass()
                    .getMethod(joinPoint.getSignature().getName(), argTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (method == null) {
            return null;
        }
        Authority ma = method.getAnnotation(Authority.class);
        return ma.value();
    }
}
