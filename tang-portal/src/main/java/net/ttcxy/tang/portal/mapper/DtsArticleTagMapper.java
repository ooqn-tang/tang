package net.ttcxy.tang.portal.mapper;

import net.ttcxy.tang.portal.entity.model.DtsArticleTag;
import net.ttcxy.tang.portal.entity.model.DtsArticleTagExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleTagMapper {
    long countByExample(DtsArticleTagExample example);

    int deleteByExample(DtsArticleTagExample example);

    int deleteByPrimaryKey(String articleTagId);

    int insert(DtsArticleTag record);

    int insertSelective(DtsArticleTag record);

    DtsArticleTag selectByPrimaryKey(String articleTagId);

    int updateByExampleSelective(@Param("record") DtsArticleTag record, @Param("example") DtsArticleTagExample example);

    int updateByExample(@Param("record") DtsArticleTag record, @Param("example") DtsArticleTagExample example);

    int updateByPrimaryKeySelective(DtsArticleTag record);

    int updateByPrimaryKey(DtsArticleTag record);
}