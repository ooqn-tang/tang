package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

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
    User selectUserByName(String username);

    /**
     * 添加User
     * @param user
     * @return
     */
    int insertUser(User user);

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
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 更新用户密码
     * @param user
     * @return
     */
    int updateUserPassword(User user);

    int updateUserByMail(@Param("mail") String mail,@Param("password") String password);
}
