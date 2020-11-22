package net.ttcxy.tang.db.mapper;

import java.util.List;
import net.ttcxy.tang.entity.model.UtsMember;
import net.ttcxy.tang.entity.model.UtsMemberExample;
import org.apache.ibatis.annotations.Param;

public interface UtsMemberMapper {
    long countByExample(UtsMemberExample example);

    int deleteByExample(UtsMemberExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsMember record);

    int insertSelective(UtsMember record);

    List<UtsMember> selectByExample(UtsMemberExample example);

    UtsMember selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsMember record, @Param("example") UtsMemberExample example);

    int updateByExample(@Param("record") UtsMember record, @Param("example") UtsMemberExample example);

    int updateByPrimaryKeySelective(UtsMember record);

    int updateByPrimaryKey(UtsMember record);
}