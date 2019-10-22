package com.qf.spring_boot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.spring_boot.config.Resources;
import com.qf.spring_boot.entity.TUser;
import com.qf.spring_boot.entity.User;
import com.qf.spring_boot.pojo.ResultBean;
import com.qf.spring_boot.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HuangPingJian
 * @Date 2019/10/21
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    /*将配置文件中的信息注入*/
/*
    @Value("${image.server}")
    private String inageServer;
*/
    @Autowired
    private IUserService userService;

    @Autowired
    private Resources resources;

   @GetMapping("hello")
    public String hello(){
       return "spring boot ...！！！！对对对bbb";

    }
 @GetMapping("{id}")
    public TUser getById(@PathVariable("id") Integer id){
     System.out.println("id:"+id);
     System.out.println("查询操作");
     return userService.getById(id);
 }
 @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Integer id){
     System.out.println("id"+id);
     System.out.println("删除操作");
        return "ok";
 }

    /*@PostMapping("add")
    public ResultBean add(@Valid User user, BindingResult bindingResult) throws JsonProcessingException {
        //判断数据校验是否通过
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            //保存错误信息的map
            Map<String,String> result = new HashMap<>();

            for (FieldError fieldError : fieldErrors) {
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                log.error("[{}]:[{}]",field,message);
                result.put(field,message);
            }
            ObjectMapper objectMapper = new ObjectMapper();
            //将对象转换为json
            String json = objectMapper.writeValueAsString(result);
            return new ResultBean("faild",json);
        }
        log.info("模拟实现了用户的添加");
        return new ResultBean("success","ok");
    }*/
    @PostMapping("add")
    public ResultBean add(@Valid User user) throws JsonProcessingException {
        //AOP 将核心业务逻辑和非核心业务逻辑做分离
        //1，核心业务逻辑：做用户数据的添加
        //2，非核心业务逻辑：做数据格式的校验

        //事务的控制
        //核心业务：做数据的添加操作
        //非核心业务：做事务控制
        log.info("模拟实现了用户的添加");
        return new ResultBean("success","ok");
    }
}
