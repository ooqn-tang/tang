package net.ttcxy.tang.gateway.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.model.DtsBlog;
import net.ttcxy.tang.gateway.model.DtsBlogExample;
import org.apache.ibatis.annotations.Param;

public interface DtsBlogMapper {
    long countByExample(DtsBlogExample example);

    int deleteByExample(DtsBlogExample example);

    int deleteByPrimaryKey(String id);

    int insert(DtsBlog record);

    int insertSelective(DtsBlog record);

    List<DtsBlog> selectByExampleWithBLOBs(DtsBlogExample example);

    List<DtsBlog> selectByExample(DtsBlogExample example);

    DtsBlog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DtsBlog record, @Param("example") DtsBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") DtsBlog record, @Param("example") DtsBlogExample example);

    int updateByExample(@Param("record") DtsBlog record, @Param("example") DtsBlogExample example);

    int updateByPrimaryKeySelective(DtsBlog record);

    int updateByPrimaryKeyWithBLOBs(DtsBlog record);

    int updateByPrimaryKey(DtsBlog record);
}