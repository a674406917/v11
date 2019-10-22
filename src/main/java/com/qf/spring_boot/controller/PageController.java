package com.qf.spring_boot.controller;

import com.qf.spring_boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HuangPingJian
 * @Date 2019/10/22
 */
@Controller
@RequestMapping("page")
@Slf4j
public class PageController {
    /*自定义日志*/
    //private Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("hello")
    public String hello(Model model) {
      /*  int i=1/0;*/
        /*自定义日志测试*/
        /*日志文件的主配置文件中设置的日志级别将会默认为此级别以上的日志将全部输出*/
        /*日志级别 debug info warn errer*/
    /*    logger.debug("debug...");
        logger.info("info...");
        logger.warn("warn...");
        logger.error("errer...");
        logger.info("你好[{}],你是第[{}]个登录网址的用户","huangpingjian","1");*/
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("errer...");
        log.info("你好[{}],你是第[{}]个登录网址的用户","huangpingjian","1");
        //携带数据
        model.addAttribute("username","java1907");
        User user = new User(1L,"1907java",new Date());
        model.addAttribute("user",user);
        model.addAttribute("money",100000);
        List<User> list = new ArrayList<>();
        list.add(new User(1L,"1907java",new Date()));
        list.add(new User(2L,"1908java",new Date()));
        model.addAttribute("list",list);
        model.addAttribute("now",new Date());
        return "hello";

    }
}
