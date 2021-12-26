package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsArticleTagDto;
import net.ttcxy.tang.portal.entity.model.DtsArticleTag;

import java.util.List;

public interface DtsArticleTagDao {
    DtsArticleTagDto selectTagArticleCountListByUsername(String tagId , String username);

    List<DtsArticleTagDto> selectTagList();

    List<DtsArticleTagDto> selectTagListByName(String name);

    DtsArticleTagDto selectTagByName(String name);

    List<DtsArticleTagDto> selectAllTag();

    List<DtsArticleTag> selectByArticleId(String articleId);
}
