package cn.ttcxy.mapper;

import java.util.List;

import cn.ttcxy.entity.model.DtsDanmaku;
import cn.ttcxy.entity.model.DtsDanmakuExample;
import org.apache.ibatis.annotations.Param;

public interface DtsDanmakuMapper {
    long countByExample(DtsDanmakuExample example);

    int deleteByExample(DtsDanmakuExample example);

    int insert(DtsDanmaku record);

    int insertSelective(DtsDanmaku record);

    List<DtsDanmaku> selectByExample(DtsDanmakuExample example);

    int updateByExampleSelective(@Param("record") DtsDanmaku record, @Param("example") DtsDanmakuExample example);

    int updateByExample(@Param("record") DtsDanmaku record, @Param("example") DtsDanmakuExample example);
}