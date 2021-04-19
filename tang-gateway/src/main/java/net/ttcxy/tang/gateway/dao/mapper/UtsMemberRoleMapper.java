package net.ttcxy.tang.gateway.dao.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.entity.model.UtsMemberRole;
import net.ttcxy.tang.gateway.entity.model.UtsMemberRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsMemberRoleMapper {
    long countByExample(UtsMemberRoleExample example);

    int deleteByExample(UtsMemberRoleExample example);

    int deleteByPrimaryKey(String memberRoleId);

    int insert(UtsMemberRole record);

    int insertSelective(UtsMemberRole record);

    List<UtsMemberRole> selectByExample(UtsMemberRoleExample example);

    UtsMemberRole selectByPrimaryKey(String memberRoleId);

    int updateByExampleSelective(@Param("record") UtsMemberRole record, @Param("example") UtsMemberRoleExample example);

    int updateByExample(@Param("record") UtsMemberRole record, @Param("example") UtsMemberRoleExample example);

    int updateByPrimaryKeySelective(UtsMemberRole record);

    int updateByPrimaryKey(UtsMemberRole record);
}