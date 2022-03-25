package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsArticleTagDto;
import cn.ttcxy.entity.model.DtsArticleTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DtsArticleTagDao {

    DtsArticleTagDto selectTagArticleCountListByUsername(@Param("tagId") String tagId , @Param("username") String username);

    List<DtsArticleTagDto> selectTagList();

    List<DtsArticleTagDto> selectTagListByName(@Param("name") String name);

    DtsArticleTagDto selectTagByName(@Param("name") String name);

    List<DtsArticleTagDto> selectAllTag();

    List<DtsArticleTag> selectByArticleId(@Param("articleId") String articleId);

}
