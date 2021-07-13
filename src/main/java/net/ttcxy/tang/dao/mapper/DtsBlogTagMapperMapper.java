package net.ttcxy.tang.dao.mapper;

import net.ttcxy.tang.entity.model.DtsBlogTagMapper;
import net.ttcxy.tang.entity.model.DtsBlogTagMapperExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogTagMapperMapper {
    long countByExample(DtsBlogTagMapperExample example);

    int deleteByExample(DtsBlogTagMapperExample example);

    int deleteByPrimaryKey(String blogTagMapperId);

    int insert(DtsBlogTagMapper record);

    int insertSelective(DtsBlogTagMapper record);

    DtsBlogTagMapper selectByPrimaryKey(String blogTagMapperId);

    int updateByExampleSelective(@Param("record") DtsBlogTagMapper record, @Param("example") DtsBlogTagMapperExample example);

    int updateByExample(@Param("record") DtsBlogTagMapper record, @Param("example") DtsBlogTagMapperExample example);

    int updateByPrimaryKeySelective(DtsBlogTagMapper record);

    int updateByPrimaryKey(DtsBlogTagMapper record);
}