package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tangtang.mapper.UserMapper;
import net.ttcxy.tangtang.entity.User;
import net.ttcxy.tangtang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByName(String username) {
        return userMapper.selectUserByName(username);
    }

    @Override
    public Boolean insertUser(User user) throws DuplicateKeyException {
        user.setId(IdUtil.simpleUUID());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        int count = userMapper.insertUser(user);
        if (count==1){
            return true;
        }
        return false;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Autowired
    AuthDetailsImpl authDetails;
    @Override
    public Boolean updateUserPassword(User user) {

        int code = userMapper.updateUserPassword(user);

        if (code==1){
            User authUser = authDetails.getUser();

            authUser.setNickname(user.getNickname());
            authUser.setSignature(user.getSignature());

            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean selectUsernameIsTrue(String username) {
        return userMapper.selectUsernameIsTrue(username)!=0?true:false;
    }

    @Override
    public Boolean selectMailIsTrue(String username) {
        return userMapper.selectEmailIsTrue(username)!=0?true:false;
    }

    @Override
    public Boolean updateUserByMail(String mail,String password) {

        int count = userMapper.updateUserByMail(mail,password);

        if (count==1){
            return true;
        }
        return false;
    }
}
