package net.ttcxy.tang.db.dao;

import net.ttcxy.tang.entity.UtsMemberLogin;

/**
 * 用户
 * @author huanglei
 */
public interface UtsMemberDao {

    /**
     * 通过邮箱查询用户是否存在
     * @param mail 邮箱
     * @return 查询的行数
     */
    int selectMailIsTrue(String mail);

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
    UtsMemberLogin selectMemberByName(String username);

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
    UtsMemberLogin selectMemberByMail(String mail);

}
