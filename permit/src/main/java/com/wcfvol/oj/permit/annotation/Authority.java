package com.wcfvol.oj.permit.annotation;

import com.wcfvol.oj.permit.enums.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangchunfei
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authority {
    Role value() default Role.GUEST;
}
