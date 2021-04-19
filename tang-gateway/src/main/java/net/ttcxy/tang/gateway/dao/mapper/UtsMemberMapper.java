package net.ttcxy.tang.gateway.dao.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.entity.model.UtsMember;
import net.ttcxy.tang.gateway.entity.model.UtsMemberExample;
import org.apache.ibatis.annotations.Param;

public interface UtsMemberMapper {
    long countByExample(UtsMemberExample example);

    int deleteByExample(UtsMemberExample example);

    int deleteByPrimaryKey(String memberId);

    int insert(UtsMember record);

    int insertSelective(UtsMember record);

    List<UtsMember> selectByExample(UtsMemberExample example);

    UtsMember selectByPrimaryKey(String memberId);

    int updateByExampleSelective(@Param("record") UtsMember record, @Param("example") UtsMemberExample example);

    int updateByExample(@Param("record") UtsMember record, @Param("example") UtsMemberExample example);

    int updateByPrimaryKeySelective(UtsMember record);

    int updateByPrimaryKey(UtsMember record);
}