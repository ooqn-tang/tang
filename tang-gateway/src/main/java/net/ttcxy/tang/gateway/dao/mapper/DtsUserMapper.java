package net.ttcxy.tang.gateway.dao.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.entity.model.DtsUser;
import net.ttcxy.tang.gateway.entity.model.DtsUserExample;
import org.apache.ibatis.annotations.Param;

public interface DtsUserMapper {
    long countByExample(DtsUserExample example);

    int deleteByExample(DtsUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(DtsUser record);

    int insertSelective(DtsUser record);

    List<DtsUser> selectByExample(DtsUserExample example);

    DtsUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") DtsUser record, @Param("example") DtsUserExample example);

    int updateByExample(@Param("record") DtsUser record, @Param("example") DtsUserExample example);

    int updateByPrimaryKeySelective(DtsUser record);

    int updateByPrimaryKey(DtsUser record);
}