package net.ttcxy.tang.gateway.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.model.UtsResource;
import net.ttcxy.tang.gateway.model.UtsResourceExample;
import org.apache.ibatis.annotations.Param;

public interface UtsResourceMapper {
    long countByExample(UtsResourceExample example);

    int deleteByExample(UtsResourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsResource record);

    int insertSelective(UtsResource record);

    List<UtsResource> selectByExample(UtsResourceExample example);

    UtsResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsResource record, @Param("example") UtsResourceExample example);

    int updateByExample(@Param("record") UtsResource record, @Param("example") UtsResourceExample example);

    int updateByPrimaryKeySelective(UtsResource record);

    int updateByPrimaryKey(UtsResource record);
}