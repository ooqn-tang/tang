package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.CtsCoin;
import net.ttcxy.tang.portal.entity.model.CtsCoinExample;
import org.apache.ibatis.annotations.Param;

public interface CtsCoinMapper {
    long countByExample(CtsCoinExample example);

    int deleteByExample(CtsCoinExample example);

    int deleteByPrimaryKey(String coinId);

    int insert(CtsCoin record);

    int insertSelective(CtsCoin record);

    List<CtsCoin> selectByExample(CtsCoinExample example);

    CtsCoin selectByPrimaryKey(String coinId);

    int updateByExampleSelective(@Param("record") CtsCoin record, @Param("example") CtsCoinExample example);

    int updateByExample(@Param("record") CtsCoin record, @Param("example") CtsCoinExample example);

    int updateByPrimaryKeySelective(CtsCoin record);

    int updateByPrimaryKey(CtsCoin record);
}