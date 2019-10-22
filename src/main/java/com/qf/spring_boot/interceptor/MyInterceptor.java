package com.qf.spring_boot.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author HuangPingJian
 * @Date 2019/10/21
 */
@Component
public class MyInterceptor implements HandlerInterceptor{
        //预处理

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor....preHandle");
                  //是否放行
                return true;
    }
}
