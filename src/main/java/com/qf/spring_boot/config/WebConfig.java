package com.qf.spring_boot.config;

import com.qf.spring_boot.filter.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author HuangPingJian
 * @Date 2019/10/21
 */
@Configuration
public class WebConfig {
    @Autowired
    private MyFilter myFilter;

    @Bean
    public FilterRegistrationBean init(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setName("MyFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;

    }
}
