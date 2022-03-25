package cn.ttcxy.mapper.dao;


import cn.ttcxy.entity.model.UtsAuthor;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户
 */
public interface UtsAuthorDao {

    @MapKey("username")
    List<Map<String,String>> selectAuthorArticleCount();

    int selectMailIsTrue(@Param("mail") String mail);

    int selectUsernameIsTrue(@Param("username") String username);

    UtsAuthor selectAuthorByName(@Param("authorName") String authorName);

    int selectNicknameIsTrue(@Param("nickname") String nickname);

    UtsAuthor selectAuthorByMailAll(@Param("mail") String mail);

    List<UtsAuthor> selectAuthor();
}
