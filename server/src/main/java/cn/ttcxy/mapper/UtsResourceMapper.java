package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.UtsResource;
import cn.ttcxy.entity.model.UtsResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UtsResourceMapper {
    long countByExample(UtsResourceExample example);

    int deleteByExample(UtsResourceExample example);

    int deleteByPrimaryKey(String resourceId);

    int insert(UtsResource row);

    int insertSelective(UtsResource row);

    List<UtsResource> selectByExample(UtsResourceExample example);

    UtsResource selectByPrimaryKey(String resourceId);

    int updateByExampleSelective(@Param("row") UtsResource row, @Param("example") UtsResourceExample example);

    int updateByExample(@Param("row") UtsResource row, @Param("example") UtsResourceExample example);

    int updateByPrimaryKeySelective(UtsResource row);

    int updateByPrimaryKey(UtsResource row);
}