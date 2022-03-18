package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.UtsResourceRole;
import cn.ttcxy.entity.model.UtsResourceRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsResourceRoleMapper {
    long countByExample(UtsResourceRoleExample example);

    int deleteByExample(UtsResourceRoleExample example);

    int deleteByPrimaryKey(String resourceRoleId);

    int insert(UtsResourceRole record);

    int insertSelective(UtsResourceRole record);

    List<UtsResourceRole> selectByExample(UtsResourceRoleExample example);

    UtsResourceRole selectByPrimaryKey(String resourceRoleId);

    int updateByExampleSelective(@Param("record") UtsResourceRole record, @Param("example") UtsResourceRoleExample example);

    int updateByExample(@Param("record") UtsResourceRole record, @Param("example") UtsResourceRoleExample example);

    int updateByPrimaryKeySelective(UtsResourceRole record);

    int updateByPrimaryKey(UtsResourceRole record);
}