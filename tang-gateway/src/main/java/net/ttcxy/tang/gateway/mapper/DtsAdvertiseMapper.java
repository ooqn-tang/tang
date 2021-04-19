package net.ttcxy.tang.gateway.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.model.DtsAdvertise;
import net.ttcxy.tang.gateway.model.DtsAdvertiseExample;
import org.apache.ibatis.annotations.Param;

public interface DtsAdvertiseMapper {
    long countByExample(DtsAdvertiseExample example);

    int deleteByExample(DtsAdvertiseExample example);

    int deleteByPrimaryKey(String id);

    int insert(DtsAdvertise record);

    int insertSelective(DtsAdvertise record);

    List<DtsAdvertise> selectByExample(DtsAdvertiseExample example);

    DtsAdvertise selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DtsAdvertise record, @Param("example") DtsAdvertiseExample example);

    int updateByExample(@Param("record") DtsAdvertise record, @Param("example") DtsAdvertiseExample example);

    int updateByPrimaryKeySelective(DtsAdvertise record);

    int updateByPrimaryKey(DtsAdvertise record);
}