package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsAuthorRole;
import net.ttcxy.tang.model.UtsAuthorRoleExample;
import org.apache.ibatis.annotations.Param;

public interface UtsAuthorRoleMapper {
    long countByExample(UtsAuthorRoleExample example);

    int deleteByExample(UtsAuthorRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsAuthorRole record);

    int insertSelective(UtsAuthorRole record);

    List<UtsAuthorRole> selectByExample(UtsAuthorRoleExample example);

    UtsAuthorRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsAuthorRole record, @Param("example") UtsAuthorRoleExample example);

    int updateByExample(@Param("record") UtsAuthorRole record, @Param("example") UtsAuthorRoleExample example);

    int updateByPrimaryKeySelective(UtsAuthorRole record);

    int updateByPrimaryKey(UtsAuthorRole record);
}