package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.DtsVideo;
import cn.ttcxy.entity.model.DtsVideoExample;
import org.apache.ibatis.annotations.Param;

public interface DtsVideoMapper {
    long countByExample(DtsVideoExample example);

    int deleteByExample(DtsVideoExample example);

    int deleteByPrimaryKey(String videoId);

    int insert(DtsVideo record);

    int insertSelective(DtsVideo record);

    List<DtsVideo> selectByExample(DtsVideoExample example);

    DtsVideo selectByPrimaryKey(String videoId);

    int updateByExampleSelective(@Param("record") DtsVideo record, @Param("example") DtsVideoExample example);

    int updateByExample(@Param("record") DtsVideo record, @Param("example") DtsVideoExample example);

    int updateByPrimaryKeySelective(DtsVideo record);

    int updateByPrimaryKey(DtsVideo record);
}