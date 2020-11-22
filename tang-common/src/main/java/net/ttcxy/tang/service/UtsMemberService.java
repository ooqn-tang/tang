package net.ttcxy.tang.service;

import net.ttcxy.tang.entity.UtsMemberLogin;
import net.ttcxy.tang.entity.model.UtsMember;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务
 * @author huanglei
 */
@Service
public interface UtsMemberService {

    /**
     * 通过用户名查询
     * @param name 用户名
     * @return 登录用户
     */
    UtsMemberLogin selectUserByName(String name) ;


    /**
     * 通过邮箱好获取登录用户
     * @param mail 邮箱
     * @return 登录用户
     */
    UtsMemberLogin selectLoginMemberByMail(String mail);

    /**
     * 添加用户
     * @param author user
     * @return 影响的行数
     */
    int insertAuthor(UtsMember author);

    /**
     * 更新用户
     * @param author user
     * @return 影响的行数
     */
    int updateAuthor(UtsMember author);

    /**
     * 更新密码
     * @param author user
     * @return 影响的行数
     */
    int updateAuthorPassword(UtsMember author);

    /**
     * 用户是否存在
     * @param username 用户名
     * @return 是否存在
     */
    Boolean selectUsernameIsTrue(String username);

    /**
     * 昵称查询是否存在
     * @param nickname 昵称
     * @return 是否存在
     */
    Boolean selectNicknameIsTrue(String nickname);

    /**
     * 用户邮箱是否存在
     * @param mail 邮箱
     * @return 是否存在
     */
    Boolean selectMailIsTrue(String mail);

    /**
     * 通过邮箱更新用户
     * @param mail 邮箱
     * @param password 密码
     * @return 影响的行数
     */
    int updateUserByMail(String mail,String password);

    /**
     * 用户列表
     * @param page 页码
     * @return 列表
     */
    List<UtsMember> listAuthor(Integer page);



}
