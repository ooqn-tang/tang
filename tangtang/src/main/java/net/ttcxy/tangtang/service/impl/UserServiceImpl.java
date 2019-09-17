package net.ttcxy.tangtang.service.impl;

import net.ttcxy.tangtang.mapper.UserMapper;
import net.ttcxy.tangtang.entity.User;
import net.ttcxy.tangtang.service.UserService;
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
