package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.UtsRole;
import cn.ttcxy.entity.model.UtsRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsRoleMapper {
    long countByExample(UtsRoleExample example);

    int deleteByExample(UtsRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(UtsRole record);

    int insertSelective(UtsRole record);

    List<UtsRole> selectByExample(UtsRoleExample example);

    UtsRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") UtsRole record, @Param("example") UtsRoleExample example);

    int updateByExample(@Param("record") UtsRole record, @Param("example") UtsRoleExample example);

    int updateByPrimaryKeySelective(UtsRole record);

    int updateByPrimaryKey(UtsRole record);
}