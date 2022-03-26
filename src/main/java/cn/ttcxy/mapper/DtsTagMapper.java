package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsTag;
import cn.ttcxy.entity.model.DtsTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsTagMapper {
    long countByExample(DtsTagExample example);

    int deleteByExample(DtsTagExample example);

    int deleteByPrimaryKey(String tagId);

    int insert(DtsTag row);

    int insertSelective(DtsTag row);

    List<DtsTag> selectByExample(DtsTagExample example);

    DtsTag selectByPrimaryKey(String tagId);

    int updateByExampleSelective(@Param("row") DtsTag row, @Param("example") DtsTagExample example);

    int updateByExample(@Param("row") DtsTag row, @Param("example") DtsTagExample example);

    int updateByPrimaryKeySelective(DtsTag row);

    int updateByPrimaryKey(DtsTag row);
}