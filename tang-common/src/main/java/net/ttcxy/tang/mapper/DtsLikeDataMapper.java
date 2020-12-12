package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.DtsLikeData;
import net.ttcxy.tang.model.DtsLikeDataExample;
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