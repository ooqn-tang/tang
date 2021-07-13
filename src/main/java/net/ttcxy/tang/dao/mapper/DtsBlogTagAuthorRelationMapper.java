package net.ttcxy.tang.dao.mapper;

import net.ttcxy.tang.entity.model.DtsBlogTagAuthorRelation;
import net.ttcxy.tang.entity.model.DtsBlogTagAuthorRelationExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogTagAuthorRelationMapper {
    long countByExample(DtsBlogTagAuthorRelationExample example);

    int deleteByExample(DtsBlogTagAuthorRelationExample example);

    int deleteByPrimaryKey(String blogTagAuthorRelationId);

    int insert(DtsBlogTagAuthorRelation record);

    int insertSelective(DtsBlogTagAuthorRelation record);

    DtsBlogTagAuthorRelation selectByPrimaryKey(String blogTagAuthorRelationId);

    int updateByExampleSelective(@Param("record") DtsBlogTagAuthorRelation record, @Param("example") DtsBlogTagAuthorRelationExample example);

    int updateByExample(@Param("record") DtsBlogTagAuthorRelation record, @Param("example") DtsBlogTagAuthorRelationExample example);

    int updateByPrimaryKeySelective(DtsBlogTagAuthorRelation record);

    int updateByPrimaryKey(DtsBlogTagAuthorRelation record);
}