package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsAdminRole;
import net.ttcxy.tang.model.UtsAdminRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsAdminRoleMapper {
    long countByExample(UtsAdminRoleExample example);

    int deleteByExample(UtsAdminRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsAdminRole record);

    int insertSelective(UtsAdminRole record);

    List<UtsAdminRole> selectByExample(UtsAdminRoleExample example);

    UtsAdminRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsAdminRole record, @Param("example") UtsAdminRoleExample example);

    int updateByExample(@Param("record") UtsAdminRole record, @Param("example") UtsAdminRoleExample example);

    int updateByPrimaryKeySelective(UtsAdminRole record);

    int updateByPrimaryKey(UtsAdminRole record);
}