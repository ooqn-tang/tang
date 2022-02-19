package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.PtsProperty;
import net.ttcxy.tang.portal.entity.model.PtsPropertyExample;
import org.apache.ibatis.annotations.Param;

public interface PtsPropertyMapper {
    long countByExample(PtsPropertyExample example);

    int deleteByExample(PtsPropertyExample example);

    int deleteByPrimaryKey(String propertyId);

    int insert(PtsProperty record);

    int insertSelective(PtsProperty record);

    List<PtsProperty> selectByExample(PtsPropertyExample example);

    PtsProperty selectByPrimaryKey(String propertyId);

    int updateByExampleSelective(@Param("record") PtsProperty record, @Param("example") PtsPropertyExample example);

    int updateByExample(@Param("record") PtsProperty record, @Param("example") PtsPropertyExample example);

    int updateByPrimaryKeySelective(PtsProperty record);

    int updateByPrimaryKey(PtsProperty record);
}