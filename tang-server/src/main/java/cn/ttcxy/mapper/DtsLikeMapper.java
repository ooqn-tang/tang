package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsLike;
import cn.ttcxy.entity.model.DtsLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsLikeMapper {
    long countByExample(DtsLikeExample example);

    int deleteByExample(DtsLikeExample example);

    int deleteByPrimaryKey(String likeId);

    int insert(DtsLike row);

    int insertSelective(DtsLike row);

    List<DtsLike> selectByExample(DtsLikeExample example);

    DtsLike selectByPrimaryKey(String likeId);

    int updateByExampleSelective(@Param("row") DtsLike row, @Param("example") DtsLikeExample example);

    int updateByExample(@Param("row") DtsLike row, @Param("example") DtsLikeExample example);

    int updateByPrimaryKeySelective(DtsLike row);

    int updateByPrimaryKey(DtsLike row);
}