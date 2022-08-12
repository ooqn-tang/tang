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

    int selectMailIsTrue(String mail);

    int selectUsernameIsTrue(String username);

    UtsAuthor selectAuthorByName(String authorName);

    int selectNicknameIsTrue(String nickname);

    UtsAuthor selectAuthorByMailAll(String mail);

    List<UtsAuthor> selectAuthor();
}
