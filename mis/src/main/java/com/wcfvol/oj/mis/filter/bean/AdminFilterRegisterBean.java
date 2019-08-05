package com.wcfvol.oj.mis.filter.bean;

import com.wcfvol.oj.mis.filter.AdminFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.servlet.Filter;
@Configuration
public class AdminFilterRegisterBean {

    @Bean
    public FilterRegistrationBean<Filter> adminFilter() {
        FilterRegistrationBean<Filter> myFilter = new FilterRegistrationBean<>();
        myFilter.setFilter(getFilter());
        myFilter.addUrlPatterns("/admin/*");
        myFilter.setOrder(1);
        return myFilter;
    }

    @Bean
    Filter getFilter() {
        return new AdminFilter();
    }
}
