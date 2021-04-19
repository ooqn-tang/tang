package net.ttcxy.tang.gateway.dao.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.entity.model.UtsMemberState;
import net.ttcxy.tang.gateway.entity.model.UtsMemberStateExample;
import org.apache.ibatis.annotations.Param;

public interface UtsMemberStateMapper {
    long countByExample(UtsMemberStateExample example);

    int deleteByExample(UtsMemberStateExample example);

    int deleteByPrimaryKey(Integer memberStateId);

    int insert(UtsMemberState record);

    int insertSelective(UtsMemberState record);

    List<UtsMemberState> selectByExample(UtsMemberStateExample example);

    UtsMemberState selectByPrimaryKey(Integer memberStateId);

    int updateByExampleSelective(@Param("record") UtsMemberState record, @Param("example") UtsMemberStateExample example);

    int updateByExample(@Param("record") UtsMemberState record, @Param("example") UtsMemberStateExample example);

    int updateByPrimaryKeySelective(UtsMemberState record);

    int updateByPrimaryKey(UtsMemberState record);
}