package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.LoginUser;

/**
 * 用户
 * @author huanglei
 */
public interface UserDao {

    /**
     * 通过邮箱查询用户是否存在
     */
    int selectEmailIsTrue(String mail);

    /**
     * 通过username查询用户是否存在
     */
    int selectUsernameIsTrue(String username);

    /**
     * 查询用户详细信息
     */
    LoginUser selectUserByName(String username);

    /**
     * 昵称是否存在
     */
    int selectNicknameIsTrue(String nickname);

    LoginUser selectLoginUserByMail(String mail);

    //TODO 通过用户ID 查询这个用户用于的权限





}
