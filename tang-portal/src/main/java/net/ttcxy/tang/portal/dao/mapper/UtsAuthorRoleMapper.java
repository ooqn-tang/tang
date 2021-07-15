package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.UtsAuthorRole;
import net.ttcxy.tang.portal.entity.model.UtsAuthorRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsAuthorRoleMapper {
    long countByExample(UtsAuthorRoleExample example);

    int deleteByExample(UtsAuthorRoleExample example);

    int deleteByPrimaryKey(String authorRoleId);

    int insert(UtsAuthorRole record);

    int insertSelective(UtsAuthorRole record);

    UtsAuthorRole selectByPrimaryKey(String authorRoleId);

    int updateByExampleSelective(@Param("record") UtsAuthorRole record, @Param("example") UtsAuthorRoleExample example);

    int updateByExample(@Param("record") UtsAuthorRole record, @Param("example") UtsAuthorRoleExample example);

    int updateByPrimaryKeySelective(UtsAuthorRole record);

    int updateByPrimaryKey(UtsAuthorRole record);
}