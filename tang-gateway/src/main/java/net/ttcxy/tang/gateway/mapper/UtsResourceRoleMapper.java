package net.ttcxy.tang.gateway.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.model.UtsResourceRole;
import net.ttcxy.tang.gateway.model.UtsResourceRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsResourceRoleMapper {
    long countByExample(UtsResourceRoleExample example);

    int deleteByExample(UtsResourceRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsResourceRole record);

    int insertSelective(UtsResourceRole record);

    List<UtsResourceRole> selectByExample(UtsResourceRoleExample example);

    UtsResourceRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsResourceRole record, @Param("example") UtsResourceRoleExample example);

    int updateByExample(@Param("record") UtsResourceRole record, @Param("example") UtsResourceRoleExample example);

    int updateByPrimaryKeySelective(UtsResourceRole record);

    int updateByPrimaryKey(UtsResourceRole record);
}