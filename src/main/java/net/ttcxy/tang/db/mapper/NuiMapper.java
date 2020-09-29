package net.ttcxy.tang.db.mapper;

import java.util.List;
import net.ttcxy.tang.entity.model.Nui;
import net.ttcxy.tang.entity.model.NuiExample;
import org.apache.ibatis.annotations.Param;

public interface NuiMapper {
    long countByExample(NuiExample example);

    int deleteByExample(NuiExample example);

    int deleteByPrimaryKey(String id);

    int insert(Nui record);

    int insertSelective(Nui record);

    List<Nui> selectByExample(NuiExample example);

    Nui selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Nui record, @Param("example") NuiExample example);

    int updateByExample(@Param("record") Nui record, @Param("example") NuiExample example);

    int updateByPrimaryKeySelective(Nui record);

    int updateByPrimaryKey(Nui record);
}