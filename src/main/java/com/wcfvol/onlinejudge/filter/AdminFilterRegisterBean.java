package com.wcfvol.onlinejudge.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AdminFilterRegisterBean {
    @Bean
    public FilterRegistrationBean adminFilter() {
        FilterRegistrationBean myFilter = new FilterRegistrationBean();
        myFilter.addUrlPatterns("/admin/*");
        myFilter.setOrder(1);
        myFilter.setFilter(new AdminFilter());
        return myFilter;
    }
}
