package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.DtsBlogTag;
import net.ttcxy.tang.portal.entity.model.DtsBlogTagExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogTagMapper {
    long countByExample(DtsBlogTagExample example);

    int deleteByExample(DtsBlogTagExample example);

    int deleteByPrimaryKey(String blogTagId);

    int insert(DtsBlogTag record);

    int insertSelective(DtsBlogTag record);

    DtsBlogTag selectByPrimaryKey(String blogTagId);

    int updateByExampleSelective(@Param("record") DtsBlogTag record, @Param("example") DtsBlogTagExample example);

    int updateByExample(@Param("record") DtsBlogTag record, @Param("example") DtsBlogTagExample example);

    int updateByPrimaryKeySelective(DtsBlogTag record);

    int updateByPrimaryKey(DtsBlogTag record);
}