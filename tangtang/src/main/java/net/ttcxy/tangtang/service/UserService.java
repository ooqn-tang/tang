package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.UserDto;
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
     * @param userDto
     * @return
     */
    Boolean insertUser(UserDto userDto);

    /**
     * 更新用户
     * @param userDto
     * @return
     */
    int updateUser(UserDto userDto);

    /**
     * 更新密码
     * @param userDto
     * @return
     */
    Boolean updateUserPassword(UserDto userDto);

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
    Boolean updateUserByMail(String mail,String password);

    /**
     * 用户列表
     * @return
     */
    List<UserDto> listUser();
}
