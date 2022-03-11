package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.DtsDanmaku;
import net.ttcxy.tang.portal.entity.model.DtsDanmakuExample;
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