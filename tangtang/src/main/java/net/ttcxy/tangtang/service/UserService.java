package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.UserDto;
import net.ttcxy.tangtang.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * 通过用户名查询
     * @param name
     * @return
     */
    UserDto selectUserByName(String name) ;

    /**
     * 添加用户
     * @param user user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 更新密码
     * @param user
     * @return
     */
    int updateUserPassword(User user);

    /**
     * 用户是否存在
     * @param username
     * @return
     */
    Boolean selectUsernameIsTrue(String username);

    /**
     * 用户邮箱是否存在
     * @param username
     * @return
     */
    Boolean selectMailIsTrue(String username);

    /**
     * 通过邮箱更新用户
     * @param mail
     * @param password
     * @return
     */
    int updateUserByMail(String mail,String password);

    /**
     * 用户列表
     * @param  page page
     * @return UserDto
     */
    List<User> listUser(Integer page);
}
