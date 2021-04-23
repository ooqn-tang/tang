package net.ttcxy.tang.gateway.dao.mapper;

import net.ttcxy.tang.gateway.entity.model.StsVisitLog;
import net.ttcxy.tang.gateway.entity.model.StsVisitLogExample;
import org.apache.ibatis.annotations.Param;

public interface StsVisitLogMapper {
    long countByExample(StsVisitLogExample example);

    int deleteByExample(StsVisitLogExample example);

    int deleteByPrimaryKey(Integer visitLogId);

    int insert(StsVisitLog record);

    int insertSelective(StsVisitLog record);

    StsVisitLog selectByPrimaryKey(Integer visitLogId);

    int updateByExampleSelective(@Param("record") StsVisitLog record, @Param("example") StsVisitLogExample example);

    int updateByExample(@Param("record") StsVisitLog record, @Param("example") StsVisitLogExample example);

    int updateByPrimaryKeySelective(StsVisitLog record);

    int updateByPrimaryKey(StsVisitLog record);
}