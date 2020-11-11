package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsRole;
import net.ttcxy.tang.model.UtsRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsRoleMapper {
    long countByExample(UtsRoleExample example);

    int deleteByExample(UtsRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsRole record);

    int insertSelective(UtsRole record);

    List<UtsRole> selectByExample(UtsRoleExample example);

    UtsRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsRole record, @Param("example") UtsRoleExample example);

    int updateByExample(@Param("record") UtsRole record, @Param("example") UtsRoleExample example);

    int updateByPrimaryKeySelective(UtsRole record);

    int updateByPrimaryKey(UtsRole record);
}