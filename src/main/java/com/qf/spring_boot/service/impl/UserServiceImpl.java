package com.qf.spring_boot.service.impl;


import com.qf.spring_boot.entity.TUser;
import com.qf.spring_boot.mapper.TUserMapper;
import com.qf.spring_boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HuangPingJian
 * @Date 2019/10/22
 */
@Service
public class UserServiceImpl implements IUserService{

     @Autowired
     private TUserMapper userMapper;
    @Override
    public TUser getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
