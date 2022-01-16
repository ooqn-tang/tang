package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.DtsArticleTagAuthorRelation;
import net.ttcxy.tang.portal.entity.model.DtsArticleTagAuthorRelationExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleTagAuthorRelationMapper {
    long countByExample(DtsArticleTagAuthorRelationExample example);

    int deleteByExample(DtsArticleTagAuthorRelationExample example);

    int deleteByPrimaryKey(String articleTagAuthorRelationId);

    int insert(DtsArticleTagAuthorRelation record);

    int insertSelective(DtsArticleTagAuthorRelation record);

    List<DtsArticleTagAuthorRelation> selectByExample(DtsArticleTagAuthorRelationExample example);

    DtsArticleTagAuthorRelation selectByPrimaryKey(String articleTagAuthorRelationId);

    int updateByExampleSelective(@Param("record") DtsArticleTagAuthorRelation record, @Param("example") DtsArticleTagAuthorRelationExample example);

    int updateByExample(@Param("record") DtsArticleTagAuthorRelation record, @Param("example") DtsArticleTagAuthorRelationExample example);

    int updateByPrimaryKeySelective(DtsArticleTagAuthorRelation record);

    int updateByPrimaryKey(DtsArticleTagAuthorRelation record);
}