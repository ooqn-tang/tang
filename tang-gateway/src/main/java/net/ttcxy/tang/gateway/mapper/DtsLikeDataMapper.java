package net.ttcxy.tang.gateway.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.model.DtsLikeData;
import net.ttcxy.tang.gateway.model.DtsLikeDataExample;
import org.apache.ibatis.annotations.Param;

public interface DtsLikeDataMapper {
    long countByExample(DtsLikeDataExample example);

    int deleteByExample(DtsLikeDataExample example);

    int insert(DtsLikeData record);

    int insertSelective(DtsLikeData record);

    List<DtsLikeData> selectByExample(DtsLikeDataExample example);

    int updateByExampleSelective(@Param("record") DtsLikeData record, @Param("example") DtsLikeDataExample example);

    int updateByExample(@Param("record") DtsLikeData record, @Param("example") DtsLikeDataExample example);
}