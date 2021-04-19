package net.ttcxy.tang.gateway.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.model.StsVisitLog;
import net.ttcxy.tang.gateway.model.StsVisitLogExample;
import org.apache.ibatis.annotations.Param;

public interface StsVisitLogMapper {
    long countByExample(StsVisitLogExample example);

    int deleteByExample(StsVisitLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StsVisitLog record);

    int insertSelective(StsVisitLog record);

    List<StsVisitLog> selectByExample(StsVisitLogExample example);

    StsVisitLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StsVisitLog record, @Param("example") StsVisitLogExample example);

    int updateByExample(@Param("record") StsVisitLog record, @Param("example") StsVisitLogExample example);

    int updateByPrimaryKeySelective(StsVisitLog record);

    int updateByPrimaryKey(StsVisitLog record);
}