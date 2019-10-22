package com.qf.spring_boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;



/**
 * @author HuangPingJian
 * @Date 2019/10/22
 */
/*封装统一的返回结果集*/
@Data
@AllArgsConstructor

public class ResultBean<T> {
    private  String status;
    private T data;
/*
    public ResultBean(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }*/
}
