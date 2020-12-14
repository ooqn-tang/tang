package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsMemberState;
import net.ttcxy.tang.model.UtsMemberStateExample;
import org.apache.ibatis.annotations.Param;

public interface UtsMemberStateMapper {
    long countByExample(UtsMemberStateExample example);

    int deleteByExample(UtsMemberStateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UtsMemberState record);

    int insertSelective(UtsMemberState record);

    List<UtsMemberState> selectByExample(UtsMemberStateExample example);

    UtsMemberState selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UtsMemberState record, @Param("example") UtsMemberStateExample example);

    int updateByExample(@Param("record") UtsMemberState record, @Param("example") UtsMemberStateExample example);

    int updateByPrimaryKeySelective(UtsMemberState record);

    int updateByPrimaryKey(UtsMemberState record);
}