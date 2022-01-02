package net.ttcxy.tang.portal.mapper;

import net.ttcxy.tang.portal.entity.model.DtsArticle;
import net.ttcxy.tang.portal.entity.model.DtsArticleExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleMapper {
    long countByExample(DtsArticleExample example);

    int deleteByExample(DtsArticleExample example);

    int deleteByPrimaryKey(String articleId);

    int insert(DtsArticle record);

    int insertSelective(DtsArticle record);

    DtsArticle selectByPrimaryKey(String articleId);

    int updateByExampleSelective(@Param("record") DtsArticle record, @Param("example") DtsArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") DtsArticle record, @Param("example") DtsArticleExample example);

    int updateByExample(@Param("record") DtsArticle record, @Param("example") DtsArticleExample example);

    int updateByPrimaryKeySelective(DtsArticle record);

    int updateByPrimaryKeyWithBLOBs(DtsArticle record);

    int updateByPrimaryKey(DtsArticle record);
}