package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.PtsCredit;
import net.ttcxy.tang.portal.entity.model.PtsCreditExample;
import org.apache.ibatis.annotations.Param;

public interface PtsCreditMapper {
    long countByExample(PtsCreditExample example);

    int deleteByExample(PtsCreditExample example);

    int insert(PtsCredit record);

    int insertSelective(PtsCredit record);

    List<PtsCredit> selectByExample(PtsCreditExample example);

    int updateByExampleSelective(@Param("record") PtsCredit record, @Param("example") PtsCreditExample example);

    int updateByExample(@Param("record") PtsCredit record, @Param("example") PtsCreditExample example);
}