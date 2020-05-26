package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import net.ttcxy.tangtang.dao.UserDao;
import net.ttcxy.tangtang.entity.UserDto;
import net.ttcxy.tangtang.mapper.UserMapper;
import net.ttcxy.tangtang.model.User;
import net.ttcxy.tangtang.model.UserExample;
import net.ttcxy.tangtang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanglei
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto selectUserByName(String username) {
        return userDao.selectUserByName(username);
    }

    @Override
    public int insertUser(User user) throws DuplicateKeyException {
        user.setId(IdUtil.simpleUUID());
        String password = user.getPassword();
        String encodePassword = new BCryptPasswordEncoder().encode(password);
        user.setPassword(encodePassword);
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Autowired
    AuthDetailsImpl authDetails;
    @Override
    public int updateUserPassword(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public Boolean selectUsernameIsTrue(String username) {
        int count = userDao.selectUsernameIsTrue(username);
        if (count > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean selectMailIsTrue(String username) {
        int count = userDao.selectEmailIsTrue(username);
        if (count > 0){
            return true;
        }
        return false;
    }

    @Override
    public int updateUserByMail(String mail,String password) {

        User user = new User();
        user.setPassword(password);

        UserExample userExample = new UserExample();
        userExample.createCriteria().andMailEqualTo(mail).andPasswordEqualTo(password);

        return userMapper.updateByExampleSelective(user,userExample);

    }

    @Override
    public List<User> listUser(Integer page){
        PageHelper.startPage(page, 10);
        return userMapper.selectByExample(new UserExample());
    }

}