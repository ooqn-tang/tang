package net.ttcxy.tang.portal.mapper;

import net.ttcxy.tang.portal.entity.model.DtsArticleTagRelation;
import net.ttcxy.tang.portal.entity.model.DtsArticleTagRelationExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleTagRelationMapper {
    long countByExample(DtsArticleTagRelationExample example);

    int deleteByExample(DtsArticleTagRelationExample example);

    int deleteByPrimaryKey(String articleTagRelationId);

    int insert(DtsArticleTagRelation record);

    int insertSelective(DtsArticleTagRelation record);

    DtsArticleTagRelation selectByPrimaryKey(String articleTagRelationId);

    int updateByExampleSelective(@Param("record") DtsArticleTagRelation record, @Param("example") DtsArticleTagRelationExample example);

    int updateByExample(@Param("record") DtsArticleTagRelation record, @Param("example") DtsArticleTagRelationExample example);

    int updateByPrimaryKeySelective(DtsArticleTagRelation record);

    int updateByPrimaryKey(DtsArticleTagRelation record);
}