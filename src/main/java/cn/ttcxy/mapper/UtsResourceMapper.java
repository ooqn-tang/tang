package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.UtsResource;
import cn.ttcxy.entity.model.UtsResourceExample;
import org.apache.ibatis.annotations.Param;

public interface UtsResourceMapper {
    long countByExample(UtsResourceExample example);

    int deleteByExample(UtsResourceExample example);

    int deleteByPrimaryKey(String resourceId);

    int insert(UtsResource record);

    int insertSelective(UtsResource record);

    List<UtsResource> selectByExample(UtsResourceExample example);

    UtsResource selectByPrimaryKey(String resourceId);

    int updateByExampleSelective(@Param("record") UtsResource record, @Param("example") UtsResourceExample example);

    int updateByExample(@Param("record") UtsResource record, @Param("example") UtsResourceExample example);

    int updateByPrimaryKeySelective(UtsResource record);

    int updateByPrimaryKey(UtsResource record);
}