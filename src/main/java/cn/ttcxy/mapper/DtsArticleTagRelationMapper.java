package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.DtsArticleTagRelation;
import cn.ttcxy.entity.model.DtsArticleTagRelationExample;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleTagRelationMapper {
    long countByExample(DtsArticleTagRelationExample example);

    int deleteByExample(DtsArticleTagRelationExample example);

    int deleteByPrimaryKey(String articleTagRelationId);

    int insert(DtsArticleTagRelation record);

    int insertSelective(DtsArticleTagRelation record);

    List<DtsArticleTagRelation> selectByExample(DtsArticleTagRelationExample example);

    DtsArticleTagRelation selectByPrimaryKey(String articleTagRelationId);

    int updateByExampleSelective(@Param("record") DtsArticleTagRelation record, @Param("example") DtsArticleTagRelationExample example);

    int updateByExample(@Param("record") DtsArticleTagRelation record, @Param("example") DtsArticleTagRelationExample example);

    int updateByPrimaryKeySelective(DtsArticleTagRelation record);

    int updateByPrimaryKey(DtsArticleTagRelation record);
}