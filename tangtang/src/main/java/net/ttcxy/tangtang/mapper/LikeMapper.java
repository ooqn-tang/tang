package net.ttcxy.tangtang.mapper;

import java.util.List;
import net.ttcxy.tangtang.model.Like;
import net.ttcxy.tangtang.model.LikeExample;
import org.apache.ibatis.annotations.Param;

public interface LikeMapper {
    long countByExample(LikeExample example);

    int deleteByExample(LikeExample example);

    int insert(Like record);

    int insertSelective(Like record);

    List<Like> selectByExample(LikeExample example);

    int updateByExampleSelective(@Param("record") Like record, @Param("example") LikeExample example);

    int updateByExample(@Param("record") Like record, @Param("example") LikeExample example);
}