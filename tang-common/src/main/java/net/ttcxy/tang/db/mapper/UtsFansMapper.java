package net.ttcxy.tang.db.mapper;

import java.util.List;
import net.ttcxy.tang.entity.model.UtsFans;
import net.ttcxy.tang.entity.model.UtsFansExample;
import org.apache.ibatis.annotations.Param;

public interface UtsFansMapper {
    long countByExample(UtsFansExample example);

    int deleteByExample(UtsFansExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsFans record);

    int insertSelective(UtsFans record);

    List<UtsFans> selectByExample(UtsFansExample example);

    UtsFans selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsFans record, @Param("example") UtsFansExample example);

    int updateByExample(@Param("record") UtsFans record, @Param("example") UtsFansExample example);

    int updateByPrimaryKeySelective(UtsFans record);

    int updateByPrimaryKey(UtsFans record);
}