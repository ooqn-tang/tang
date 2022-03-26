package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsArticleSubjectRelation;
import cn.ttcxy.entity.model.DtsArticleSubjectRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsArticleSubjectRelationMapper {
    long countByExample(DtsArticleSubjectRelationExample example);

    int deleteByExample(DtsArticleSubjectRelationExample example);

    int deleteByPrimaryKey(String articleSubjectRelationId);

    int insert(DtsArticleSubjectRelation row);

    int insertSelective(DtsArticleSubjectRelation row);

    List<DtsArticleSubjectRelation> selectByExample(DtsArticleSubjectRelationExample example);

    DtsArticleSubjectRelation selectByPrimaryKey(String articleSubjectRelationId);

    int updateByExampleSelective(@Param("row") DtsArticleSubjectRelation row, @Param("example") DtsArticleSubjectRelationExample example);

    int updateByExample(@Param("row") DtsArticleSubjectRelation row, @Param("example") DtsArticleSubjectRelationExample example);

    int updateByPrimaryKeySelective(DtsArticleSubjectRelation row);

    int updateByPrimaryKey(DtsArticleSubjectRelation row);
}