package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsVideo;
import cn.ttcxy.entity.model.DtsVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsVideoMapper {
    long countByExample(DtsVideoExample example);

    int deleteByExample(DtsVideoExample example);

    int deleteByPrimaryKey(String videoId);

    int insert(DtsVideo row);

    int insertSelective(DtsVideo row);

    List<DtsVideo> selectByExample(DtsVideoExample example);

    DtsVideo selectByPrimaryKey(String videoId);

    int updateByExampleSelective(@Param("row") DtsVideo row, @Param("example") DtsVideoExample example);

    int updateByExample(@Param("row") DtsVideo row, @Param("example") DtsVideoExample example);

    int updateByPrimaryKeySelective(DtsVideo row);

    int updateByPrimaryKey(DtsVideo row);
}