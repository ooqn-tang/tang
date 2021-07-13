package net.ttcxy.tang.dao.mapper;

import net.ttcxy.tang.entity.model.DtsAdvertise;
import net.ttcxy.tang.entity.model.DtsAdvertiseExample;
import org.apache.ibatis.annotations.Param;

public interface DtsAdvertiseMapper {
    long countByExample(DtsAdvertiseExample example);

    int deleteByExample(DtsAdvertiseExample example);

    int deleteByPrimaryKey(String advertiseId);

    int insert(DtsAdvertise record);

    int insertSelective(DtsAdvertise record);

    DtsAdvertise selectByPrimaryKey(String advertiseId);

    int updateByExampleSelective(@Param("record") DtsAdvertise record, @Param("example") DtsAdvertiseExample example);

    int updateByExample(@Param("record") DtsAdvertise record, @Param("example") DtsAdvertiseExample example);

    int updateByPrimaryKeySelective(DtsAdvertise record);

    int updateByPrimaryKey(DtsAdvertise record);
}