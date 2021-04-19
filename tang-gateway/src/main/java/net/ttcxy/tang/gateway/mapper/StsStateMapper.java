package net.ttcxy.tang.gateway.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.model.StsState;
import net.ttcxy.tang.gateway.model.StsStateExample;
import org.apache.ibatis.annotations.Param;

public interface StsStateMapper {
    long countByExample(StsStateExample example);

    int deleteByExample(StsStateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StsState record);

    int insertSelective(StsState record);

    List<StsState> selectByExample(StsStateExample example);

    StsState selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StsState record, @Param("example") StsStateExample example);

    int updateByExample(@Param("record") StsState record, @Param("example") StsStateExample example);

    int updateByPrimaryKeySelective(StsState record);

    int updateByPrimaryKey(StsState record);
}