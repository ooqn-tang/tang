package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tangtang.mapper.UserMapper;
import net.ttcxy.tangtang.entity.dto.User;
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
        user.setId(IdUtil.simpleUUID());
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setMail(mail);

        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserPassword(User user) {
        userMapper.updateUserPassword(user);
        return 0;
    }
}
