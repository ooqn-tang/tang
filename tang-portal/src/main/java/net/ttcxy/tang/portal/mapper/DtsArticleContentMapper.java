package net.ttcxy.tang.portal.mapper;

import net.ttcxy.tang.portal.entity.model.DtsArticleContent;
import net.ttcxy.tang.portal.entity.model.DtsArticleContentExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleContentMapper {
    long countByExample(DtsArticleContentExample example);

    int deleteByExample(DtsArticleContentExample example);

    int deleteByPrimaryKey(String articleId);

    int insert(DtsArticleContent record);

    int insertSelective(DtsArticleContent record);

    DtsArticleContent selectByPrimaryKey(String articleId);

    int updateByExampleSelective(@Param("record") DtsArticleContent record, @Param("example") DtsArticleContentExample example);

    int updateByExampleWithBLOBs(@Param("record") DtsArticleContent record, @Param("example") DtsArticleContentExample example);

    int updateByExample(@Param("record") DtsArticleContent record, @Param("example") DtsArticleContentExample example);

    int updateByPrimaryKeySelective(DtsArticleContent record);

    int updateByPrimaryKeyWithBLOBs(DtsArticleContent record);
}