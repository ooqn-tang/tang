package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsAdminResourceRole;
import net.ttcxy.tang.model.UtsAdminResourceRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsAdminResourceRoleMapper {
    long countByExample(UtsAdminResourceRoleExample example);

    int deleteByExample(UtsAdminResourceRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsAdminResourceRole record);

    int insertSelective(UtsAdminResourceRole record);

    List<UtsAdminResourceRole> selectByExample(UtsAdminResourceRoleExample example);

    UtsAdminResourceRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsAdminResourceRole record, @Param("example") UtsAdminResourceRoleExample example);

    int updateByExample(@Param("record") UtsAdminResourceRole record, @Param("example") UtsAdminResourceRoleExample example);

    int updateByPrimaryKeySelective(UtsAdminResourceRole record);

    int updateByPrimaryKey(UtsAdminResourceRole record);
}