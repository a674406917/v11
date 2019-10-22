package com.qf.spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author HuangPingJian
 * @Date 2019/10/21
 */
public class User {
    @JsonIgnore
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "用户名不能为空")
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date entryDate;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public User() {
    }

    public User(Long id, String name, Date entryDate) {
        this.id = id;
        this.name = name;
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", entryDate=" + entryDate +
                '}';
    }
}
