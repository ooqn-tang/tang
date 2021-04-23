package net.ttcxy.tang.gateway.dao.mapper;

import net.ttcxy.tang.gateway.entity.model.UtsFans;
import net.ttcxy.tang.gateway.entity.model.UtsFansExample;
import org.apache.ibatis.annotations.Param;

public interface UtsFansMapper {
    long countByExample(UtsFansExample example);

    int deleteByExample(UtsFansExample example);

    int deleteByPrimaryKey(String fansId);

    int insert(UtsFans record);

    int insertSelective(UtsFans record);

    UtsFans selectByPrimaryKey(String fansId);

    int updateByExampleSelective(@Param("record") UtsFans record, @Param("example") UtsFansExample example);

    int updateByExample(@Param("record") UtsFans record, @Param("example") UtsFansExample example);

    int updateByPrimaryKeySelective(UtsFans record);

    int updateByPrimaryKey(UtsFans record);
}