package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tangtang.mapper.UserMapper;
import net.ttcxy.tangtang.entity.User;
import net.ttcxy.tangtang.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public int insertUser(String username,String password,String mail) {

        User user = new User();
        user.setUsername(username);
        user.setId(IdUtil.fastSimpleUUID());
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setMail(mail);

        return userMapper.insertUser(user);
    }
}
