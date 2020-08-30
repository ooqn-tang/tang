package net.ttcxy.tang.gateway.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.model.Fans;
import net.ttcxy.tang.gateway.model.FansExample;
import org.apache.ibatis.annotations.Param;

public interface FansMapper {
    long countByExample(FansExample example);

    int deleteByExample(FansExample example);

    int deleteByPrimaryKey(String id);

    int insert(Fans record);

    int insertSelective(Fans record);

    List<Fans> selectByExample(FansExample example);

    Fans selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Fans record, @Param("example") FansExample example);

    int updateByExample(@Param("record") Fans record, @Param("example") FansExample example);

    int updateByPrimaryKeySelective(Fans record);

    int updateByPrimaryKey(Fans record);
}