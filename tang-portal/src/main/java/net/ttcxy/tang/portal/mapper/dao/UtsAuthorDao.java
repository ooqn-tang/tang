package net.ttcxy.tang.portal.mapper.dao;


import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.model.UtsRole;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * 用户
 */
public interface UtsAuthorDao {

    /**
     * 查询用户博客数
     */
    @MapKey("username")
    List<Map<String,String>> selectAuthorArticleCount();

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
     * @param authorName 用户名
     * @return 登录用户消息
     */
    UtsAuthor selectAuthorByName(String authorName);

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
    UtsAuthor selectAuthorByMailAll(String mail);

    /**
     * 查询所有作者
     * @return 作者列表
     */
    List<UtsAuthor> selectAuthor();
}
