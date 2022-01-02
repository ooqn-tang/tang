package net.ttcxy.tang.portal.mapper;

import net.ttcxy.tang.portal.entity.model.DtsArticleSubjectRelation;
import net.ttcxy.tang.portal.entity.model.DtsArticleSubjectRelationExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleSubjectRelationMapper {
    long countByExample(DtsArticleSubjectRelationExample example);

    int deleteByExample(DtsArticleSubjectRelationExample example);

    int deleteByPrimaryKey(String articleSubjectRelationId);

    int insert(DtsArticleSubjectRelation record);

    int insertSelective(DtsArticleSubjectRelation record);

    DtsArticleSubjectRelation selectByPrimaryKey(String articleSubjectRelationId);

    int updateByExampleSelective(@Param("record") DtsArticleSubjectRelation record, @Param("example") DtsArticleSubjectRelationExample example);

    int updateByExample(@Param("record") DtsArticleSubjectRelation record, @Param("example") DtsArticleSubjectRelationExample example);

    int updateByPrimaryKeySelective(DtsArticleSubjectRelation record);

    int updateByPrimaryKey(DtsArticleSubjectRelation record);
}