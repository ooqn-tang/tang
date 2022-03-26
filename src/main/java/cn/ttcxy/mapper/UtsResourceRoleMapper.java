package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.UtsResourceRole;
import cn.ttcxy.entity.model.UtsResourceRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UtsResourceRoleMapper {
    long countByExample(UtsResourceRoleExample example);

    int deleteByExample(UtsResourceRoleExample example);

    int deleteByPrimaryKey(String resourceRoleId);

    int insert(UtsResourceRole row);

    int insertSelective(UtsResourceRole row);

    List<UtsResourceRole> selectByExample(UtsResourceRoleExample example);

    UtsResourceRole selectByPrimaryKey(String resourceRoleId);

    int updateByExampleSelective(@Param("row") UtsResourceRole row, @Param("example") UtsResourceRoleExample example);

    int updateByExample(@Param("row") UtsResourceRole row, @Param("example") UtsResourceRoleExample example);

    int updateByPrimaryKeySelective(UtsResourceRole row);

    int updateByPrimaryKey(UtsResourceRole row);
}