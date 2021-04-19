package net.ttcxy.tang.gateway.dao.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.entity.model.DtsLikeData;
import net.ttcxy.tang.gateway.entity.model.DtsLikeDataExample;
import org.apache.ibatis.annotations.Param;

public interface DtsLikeDataMapper {
    long countByExample(DtsLikeDataExample example);

    int deleteByExample(DtsLikeDataExample example);

    int deleteByPrimaryKey(String likeDataId);

    int insert(DtsLikeData record);

    int insertSelective(DtsLikeData record);

    List<DtsLikeData> selectByExample(DtsLikeDataExample example);

    DtsLikeData selectByPrimaryKey(String likeDataId);

    int updateByExampleSelective(@Param("record") DtsLikeData record, @Param("example") DtsLikeDataExample example);

    int updateByExample(@Param("record") DtsLikeData record, @Param("example") DtsLikeDataExample example);

    int updateByPrimaryKeySelective(DtsLikeData record);

    int updateByPrimaryKey(DtsLikeData record);
}