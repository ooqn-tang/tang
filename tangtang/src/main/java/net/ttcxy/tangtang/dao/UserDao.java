package net.ttcxy.tangtang.dao;

import net.ttcxy.tangtang.entity.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 通过邮箱查询用户是否存在
     * @param mail
     * @return
     */
    int selectEmailIsTrue(String mail);

    /**
     * 通过username查询用户是否存在
     * @param username
     * @return
     */
    int selectUsernameIsTrue(String username);

    /**
     * 查询用户详细信息
     * @param username
     * @return
     */
    UserDto selectUserByName(String username);

    /**
     * 随机查询用户列表信息
     */
    List<UserDto> listUser();

    /**
     * 添加User
     * @param userDto
     * @return
     */
    int insertUser(UserDto userDto);

    /**
     * 通过用户邮箱查询用户是否存在
     * @param mail
     * @return
     */
    int selectUserCountByMail(String mail);

    /**
     * 通过用户名查看用户是否存在
     * @param username
     * @return
     */
    int selectUserCountByUsername(String username);

    /**
     * 更新用户信息
     * @param userDto
     * @return
     */
    int updateUser(UserDto userDto);

    /**
     * 更新用户密码
     * @param userDto
     * @return
     */
    int updateUserPassword(UserDto userDto);

    int updateUserByMail(@Param("mail") String mail,@Param("password") String password);
}
