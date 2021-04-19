package net.ttcxy.tang.gateway.dao.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.entity.model.UtsLoginLog;
import net.ttcxy.tang.gateway.entity.model.UtsLoginLogExample;
import org.apache.ibatis.annotations.Param;

public interface UtsLoginLogMapper {
    long countByExample(UtsLoginLogExample example);

    int deleteByExample(UtsLoginLogExample example);

    int deleteByPrimaryKey(Integer loginLogId);

    int insert(UtsLoginLog record);

    int insertSelective(UtsLoginLog record);

    List<UtsLoginLog> selectByExample(UtsLoginLogExample example);

    int updateByExampleSelective(@Param("record") UtsLoginLog record, @Param("example") UtsLoginLogExample example);

    int updateByExample(@Param("record") UtsLoginLog record, @Param("example") UtsLoginLogExample example);
}