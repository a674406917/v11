package com.qf.spring_boot.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.spring_boot.pojo.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HuangPingJian
 * @Date 2019/10/22
 *  * 1，写一个全局的异常处理，相当于默认处理机制
 * 2，针对特定场景的异常，比如数据校验异常，做定制化的处理机制
 */
@ControllerAdvice
public class GloablExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GloablExceptionHandler.class);

    /**
     * 做一个全局的异常处理
     *
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handlerException(Exception e){
        //1.将错误的日志记录下来
        logger.error(e.getMessage());
        //2.如果是非常重要的核心业务
        //主动通知相关的负责人，系统出bug了，赶紧看看日志
        //发短信，发邮件
        //9天
        //2.给用户反馈
        return new ResultBean("success","当前服务器繁忙，请稍后再试");
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean validationErrorHandler(BindException ex) throws JsonProcessingException {
        //1.此处先获取BindingResult
        BindingResult bindingResult = ex.getBindingResult();
        //2.获取错误信息
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        //3.组装异常信息
        Map<String,String> message = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            message.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        //4.将map转换为JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(message);
        //5.返回错误信息
        return new ResultBean("400",json);
    }
}
