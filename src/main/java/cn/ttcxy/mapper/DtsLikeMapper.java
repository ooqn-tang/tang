package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.DtsLike;
import cn.ttcxy.entity.model.DtsLikeExample;
import org.apache.ibatis.annotations.Param;

public interface DtsLikeMapper {
    long countByExample(DtsLikeExample example);

    int deleteByExample(DtsLikeExample example);

    int deleteByPrimaryKey(String likeId);

    int insert(DtsLike record);

    int insertSelective(DtsLike record);

    List<DtsLike> selectByExample(DtsLikeExample example);

    DtsLike selectByPrimaryKey(String likeId);

    int updateByExampleSelective(@Param("record") DtsLike record, @Param("example") DtsLikeExample example);

    int updateByExample(@Param("record") DtsLike record, @Param("example") DtsLikeExample example);

    int updateByPrimaryKeySelective(DtsLike record);

    int updateByPrimaryKey(DtsLike record);
}