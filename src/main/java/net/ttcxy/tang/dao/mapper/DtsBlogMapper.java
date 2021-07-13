package net.ttcxy.tang.dao.mapper;

import net.ttcxy.tang.entity.model.DtsBlog;
import net.ttcxy.tang.entity.model.DtsBlogExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogMapper {
    long countByExample(DtsBlogExample example);

    int deleteByExample(DtsBlogExample example);

    int deleteByPrimaryKey(String blogId);

    int insert(DtsBlog record);

    int insertSelective(DtsBlog record);

    DtsBlog selectByPrimaryKey(String blogId);

    int updateByExampleSelective(@Param("record") DtsBlog record, @Param("example") DtsBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") DtsBlog record, @Param("example") DtsBlogExample example);

    int updateByExample(@Param("record") DtsBlog record, @Param("example") DtsBlogExample example);

    int updateByPrimaryKeySelective(DtsBlog record);

    int updateByPrimaryKeyWithBLOBs(DtsBlog record);

    int updateByPrimaryKey(DtsBlog record);
}