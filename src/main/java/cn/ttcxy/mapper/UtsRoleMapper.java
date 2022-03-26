package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.UtsRole;
import cn.ttcxy.entity.model.UtsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UtsRoleMapper {
    long countByExample(UtsRoleExample example);

    int deleteByExample(UtsRoleExample example);

    int deleteByPrimaryKey(String roleId);

    int insert(UtsRole row);

    int insertSelective(UtsRole row);

    List<UtsRole> selectByExample(UtsRoleExample example);

    UtsRole selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("row") UtsRole row, @Param("example") UtsRoleExample example);

    int updateByExample(@Param("row") UtsRole row, @Param("example") UtsRoleExample example);

    int updateByPrimaryKeySelective(UtsRole row);

    int updateByPrimaryKey(UtsRole row);
}