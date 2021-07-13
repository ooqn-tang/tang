package net.ttcxy.tang.dao.mapper;

import net.ttcxy.tang.entity.model.UtsResourceRole;
import net.ttcxy.tang.entity.model.UtsResourceRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsResourceRoleMapper {
    long countByExample(UtsResourceRoleExample example);

    int deleteByExample(UtsResourceRoleExample example);

    int deleteByPrimaryKey(String resourceRoleId);

    int insert(UtsResourceRole record);

    int insertSelective(UtsResourceRole record);

    UtsResourceRole selectByPrimaryKey(String resourceRoleId);

    int updateByExampleSelective(@Param("record") UtsResourceRole record, @Param("example") UtsResourceRoleExample example);

    int updateByExample(@Param("record") UtsResourceRole record, @Param("example") UtsResourceRoleExample example);

    int updateByPrimaryKeySelective(UtsResourceRole record);

    int updateByPrimaryKey(UtsResourceRole record);
}