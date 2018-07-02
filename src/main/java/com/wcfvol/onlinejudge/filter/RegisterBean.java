package com.wcfvol.onlinejudge.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RegisterBean {
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean myFilter = new FilterRegistrationBean();
        myFilter.addUrlPatterns("/filterapi/*");
        myFilter.setFilter(new JwtAuthenticationFilter());
        return myFilter;
    }
}
