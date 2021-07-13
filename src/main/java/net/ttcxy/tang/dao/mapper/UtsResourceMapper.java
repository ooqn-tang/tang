package net.ttcxy.tang.dao.mapper;

import net.ttcxy.tang.entity.model.UtsResource;
import net.ttcxy.tang.entity.model.UtsResourceExample;
import org.apache.ibatis.annotations.Param;

public interface UtsResourceMapper {
    long countByExample(UtsResourceExample example);

    int deleteByExample(UtsResourceExample example);

    int deleteByPrimaryKey(String resourceId);

    int insert(UtsResource record);

    int insertSelective(UtsResource record);

    UtsResource selectByPrimaryKey(String resourceId);

    int updateByExampleSelective(@Param("record") UtsResource record, @Param("example") UtsResourceExample example);

    int updateByExample(@Param("record") UtsResource record, @Param("example") UtsResourceExample example);

    int updateByPrimaryKeySelective(UtsResource record);

    int updateByPrimaryKey(UtsResource record);
}