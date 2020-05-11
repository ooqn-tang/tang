package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tangtang.dao.UserDao;
import net.ttcxy.tangtang.entity.UserDto;
import net.ttcxy.tangtang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto selectUserByName(String username) {
        return userDao.selectUserByName(username);
    }

    @Override
    public Boolean insertUser(UserDto userDto) throws DuplicateKeyException {
        userDto.setId(IdUtil.simpleUUID());
        userDto.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));

        int count = userDao.insertUser(userDto);
        if (count==1){
            return true;
        }
        return false;
    }

    @Override
    public int updateUser(UserDto userDto) {
        return userDao.updateUser(userDto);
    }

    @Autowired
    AuthDetailsImpl authDetails;
    @Override
    public Boolean updateUserPassword(UserDto userDto) {

        int code = userDao.updateUserPassword(userDto);

        if (code==1){
            UserDto authUserDto = authDetails.getUser();

            authUserDto.setNickname(userDto.getNickname());
            authUserDto.setSignature(userDto.getSignature());

            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean selectUsernameIsTrue(String username) {
        return userDao.selectUsernameIsTrue(username)!=0?true:false;
    }

    @Override
    public Boolean selectMailIsTrue(String username) {
        return userDao.selectEmailIsTrue(username)!=0?true:false;
    }

    @Override
    public Boolean updateUserByMail(String mail,String password) {

        int count = userDao.updateUserByMail(mail,password);

        if (count==1){
            return true;
        }
        return false;
    }
    public List<UserDto> listUser(){
        return userDao.listUser();
    }

}
