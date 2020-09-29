package net.ttcxy.tang.db.mapper;

import java.util.List;
import net.ttcxy.tang.entity.model.Fans;
import net.ttcxy.tang.entity.model.FansExample;
import org.apache.ibatis.annotations.Param;

public interface FansMapper {
    long countByExample(FansExample example);

    int deleteByExample(FansExample example);

    int insert(Fans record);

    int insertSelective(Fans record);

    List<Fans> selectByExample(FansExample example);

    int updateByExampleSelective(@Param("record") Fans record, @Param("example") FansExample example);

    int updateByExample(@Param("record") Fans record, @Param("example") FansExample example);
}