package com.qf.spring_boot.config;

import com.qf.spring_boot.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author HuangPingJian
 * @Date 2019/10/21
 */
@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer{

    @Autowired
    private MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加我们的拦截器配置
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
