package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsArticleTagDto;
import cn.ttcxy.entity.model.DtsArticleTag;

import java.util.List;

public interface DtsArticleTagDao {
    DtsArticleTagDto selectTagArticleCountListByUsername(String tagId , String username);

    List<DtsArticleTagDto> selectTagList();

    List<DtsArticleTagDto> selectTagListByName(String name);

    DtsArticleTagDto selectTagByName(String name);

    List<DtsArticleTagDto> selectAllTag();

    List<DtsArticleTag> selectByArticleId(String articleId);
}
