package net.ttcxy.tang.gateway.dao.mapper;

import net.ttcxy.tang.gateway.entity.model.DtsBlogSubjectRelation;
import net.ttcxy.tang.gateway.entity.model.DtsBlogSubjectRelationExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogSubjectRelationMapper {
    long countByExample(DtsBlogSubjectRelationExample example);

    int deleteByExample(DtsBlogSubjectRelationExample example);

    int deleteByPrimaryKey(String blogSubjectRelationId);

    int insert(DtsBlogSubjectRelation record);

    int insertSelective(DtsBlogSubjectRelation record);

    DtsBlogSubjectRelation selectByPrimaryKey(String blogSubjectRelationId);

    int updateByExampleSelective(@Param("record") DtsBlogSubjectRelation record, @Param("example") DtsBlogSubjectRelationExample example);

    int updateByExample(@Param("record") DtsBlogSubjectRelation record, @Param("example") DtsBlogSubjectRelationExample example);

    int updateByPrimaryKeySelective(DtsBlogSubjectRelation record);

    int updateByPrimaryKey(DtsBlogSubjectRelation record);
}