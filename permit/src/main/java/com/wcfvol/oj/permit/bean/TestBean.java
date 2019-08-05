package com.wcfvol.oj.permit.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class TestBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("hello !");
    }
}
