package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.UtsAuthorRole;
import cn.ttcxy.entity.model.UtsAuthorRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UtsAuthorRoleMapper {
    long countByExample(UtsAuthorRoleExample example);

    int deleteByExample(UtsAuthorRoleExample example);

    int deleteByPrimaryKey(String authorRoleId);

    int insert(UtsAuthorRole row);

    int insertSelective(UtsAuthorRole row);

    List<UtsAuthorRole> selectByExample(UtsAuthorRoleExample example);

    UtsAuthorRole selectByPrimaryKey(String authorRoleId);

    int updateByExampleSelective(@Param("row") UtsAuthorRole row, @Param("example") UtsAuthorRoleExample example);

    int updateByExample(@Param("row") UtsAuthorRole row, @Param("example") UtsAuthorRoleExample example);

    int updateByPrimaryKeySelective(UtsAuthorRole row);

    int updateByPrimaryKey(UtsAuthorRole row);
}