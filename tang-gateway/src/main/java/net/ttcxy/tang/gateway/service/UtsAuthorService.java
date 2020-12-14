package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.gateway.entity.UtsMemberLogin;
import net.ttcxy.tang.gateway.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.model.UtsAuthor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务
 * @author huanglei
 */
@Service
public interface UtsAuthorService {

    /**
     * 通过用户名查询
     * @param name 用户名
     * @return 登录用户
     */
    UtsMemberLogin selectMemberByName(String name) ;


    /**
     * 通过邮箱好获取登录用户
     * @param mail 邮箱
     * @return 登录用户
     */
    UtsMemberLogin selectMemberByMail(String mail);

    /**
     * 添加用户
     * @param author user
     * @return 影响的行数
     */
    int insertMember(UtsAuthor author);

    /**
     * 更新用户
     * @param member user
     * @return 影响的行数
     */
    int updateMember(UtsAuthor member);

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
     * 用户列表
     * @param page 页码
     * @return 列表
     */
    List<UtsAuthor> memberList(Integer page);

    /**
     * 用户列表,包含角色
     * @param page 页码
     * @return 列表
     */
    List<UtsAuthorDto> memberListDto(Integer page);



}
