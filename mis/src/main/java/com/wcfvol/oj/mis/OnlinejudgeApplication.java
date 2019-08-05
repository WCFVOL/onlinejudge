package com.wcfvol.oj.mis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wangchunfei
 */
@SpringBootApplication
@MapperScan(basePackages = "tk.mybatis.pagehelper")
@ComponentScan("com.wcfvol.oj.permit")
public class OnlinejudgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinejudgeApplication.class, args);
    }
}
