package net.ttcxy.tangtang.mapper;

import java.util.List;
import net.ttcxy.tangtang.model.UserIp;
import net.ttcxy.tangtang.model.UserIpExample;
import org.apache.ibatis.annotations.Param;

public interface UserIpMapper {
    long countByExample(UserIpExample example);

    int deleteByExample(UserIpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserIp record);

    int insertSelective(UserIp record);

    List<UserIp> selectByExample(UserIpExample example);

    UserIp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserIp record, @Param("example") UserIpExample example);

    int updateByExample(@Param("record") UserIp record, @Param("example") UserIpExample example);

    int updateByPrimaryKeySelective(UserIp record);

    int updateByPrimaryKey(UserIp record);
}