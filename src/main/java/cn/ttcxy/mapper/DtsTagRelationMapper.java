package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsTagRelation;
import cn.ttcxy.entity.model.DtsTagRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsTagRelationMapper {
    long countByExample(DtsTagRelationExample example);

    int deleteByExample(DtsTagRelationExample example);

    int deleteByPrimaryKey(String tagId);

    int insert(DtsTagRelation row);

    int insertSelective(DtsTagRelation row);

    List<DtsTagRelation> selectByExample(DtsTagRelationExample example);

    DtsTagRelation selectByPrimaryKey(String tagId);

    int updateByExampleSelective(@Param("row") DtsTagRelation row, @Param("example") DtsTagRelationExample example);

    int updateByExample(@Param("row") DtsTagRelation row, @Param("example") DtsTagRelationExample example);

    int updateByPrimaryKeySelective(DtsTagRelation row);

    int updateByPrimaryKey(DtsTagRelation row);
}