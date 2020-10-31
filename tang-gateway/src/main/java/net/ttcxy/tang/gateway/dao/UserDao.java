package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.LoginUser;

/**
 * 用户
 * @author huanglei
 */
public interface UserDao {

    /**
     * 通过邮箱查询用户是否存在
     * @param mail 邮箱
     * @return 查询的行数
     */
    int selectEmailIsTrue(String mail);

    /**
     * 通过username查询用户是否存在
     * @param username 用户名
     * @return 查询的行数
     */
    int selectUsernameIsTrue(String username);

    /**
     * 查询用户详细信息
     * @param username 用户名
     * @return 登录用户消息
     */
    LoginUser selectUserByName(String username);

    /**
     * 昵称是否存在
     * @param nickname 昵称
     * @return 查询的行数
     */
    int selectNicknameIsTrue(String nickname);

    /**
     * 通过邮箱查询登录用户信息
     * @param mail 邮箱
     * @return 登录用户
     */
    LoginUser selectLoginUserByMail(String mail);

}
