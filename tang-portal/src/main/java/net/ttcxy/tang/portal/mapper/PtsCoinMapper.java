package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.PtsCoin;
import net.ttcxy.tang.portal.entity.model.PtsCoinExample;
import org.apache.ibatis.annotations.Param;

public interface PtsCoinMapper {
    long countByExample(PtsCoinExample example);

    int deleteByExample(PtsCoinExample example);

    int deleteByPrimaryKey(String coinId);

    int insert(PtsCoin record);

    int insertSelective(PtsCoin record);

    List<PtsCoin> selectByExample(PtsCoinExample example);

    PtsCoin selectByPrimaryKey(String coinId);

    int updateByExampleSelective(@Param("record") PtsCoin record, @Param("example") PtsCoinExample example);

    int updateByExample(@Param("record") PtsCoin record, @Param("example") PtsCoinExample example);

    int updateByPrimaryKeySelective(PtsCoin record);

    int updateByPrimaryKey(PtsCoin record);
}