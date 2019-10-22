package com.qf.spring_boot.service;

import com.qf.spring_boot.entity.TUser;

/**
 * @author HuangPingJian
 * @Date 2019/10/22
 */
public interface IUserService {
    public TUser getById(Integer id);
}
