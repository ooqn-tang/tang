package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsDanmaku;
import cn.ttcxy.entity.model.DtsDanmakuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsDanmakuMapper {
    long countByExample(DtsDanmakuExample example);

    int deleteByExample(DtsDanmakuExample example);

    int insert(DtsDanmaku row);

    int insertSelective(DtsDanmaku row);

    List<DtsDanmaku> selectByExample(DtsDanmakuExample example);

    int updateByExampleSelective(@Param("row") DtsDanmaku row, @Param("example") DtsDanmakuExample example);

    int updateByExample(@Param("row") DtsDanmaku row, @Param("example") DtsDanmakuExample example);
}