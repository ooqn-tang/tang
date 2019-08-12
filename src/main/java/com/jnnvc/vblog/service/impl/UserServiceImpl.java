package com.jnnvc.vblog.service.impl;

import com.jnnvc.vblog.mapper.UserMapper;
import com.jnnvc.vblog.entity.User;
import com.jnnvc.vblog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User selectUserByName(String username) {
        return userMapper.selectUserByName(username);
    }
}
