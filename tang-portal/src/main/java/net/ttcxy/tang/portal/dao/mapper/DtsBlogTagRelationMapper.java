package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.DtsBlogTagRelation;
import net.ttcxy.tang.portal.entity.model.DtsBlogTagRelationExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogTagRelationMapper {
    long countByExample(DtsBlogTagRelationExample example);

    int deleteByExample(DtsBlogTagRelationExample example);

    int deleteByPrimaryKey(String blogTagRelationId);

    int insert(DtsBlogTagRelation record);

    int insertSelective(DtsBlogTagRelation record);

    DtsBlogTagRelation selectByPrimaryKey(String blogTagRelationId);

    int updateByExampleSelective(@Param("record") DtsBlogTagRelation record, @Param("example") DtsBlogTagRelationExample example);

    int updateByExample(@Param("record") DtsBlogTagRelation record, @Param("example") DtsBlogTagRelationExample example);

    int updateByPrimaryKeySelective(DtsBlogTagRelation record);

    int updateByPrimaryKey(DtsBlogTagRelation record);
}