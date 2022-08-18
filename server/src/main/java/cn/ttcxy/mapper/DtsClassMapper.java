package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsClass;
import cn.ttcxy.entity.model.DtsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsClassMapper {
    long countByExample(DtsClassExample example);

    int deleteByExample(DtsClassExample example);

    int deleteByPrimaryKey(String classId);

    int insert(DtsClass row);

    int insertSelective(DtsClass row);

    List<DtsClass> selectByExample(DtsClassExample example);

    DtsClass selectByPrimaryKey(String classId);

    int updateByExampleSelective(@Param("row") DtsClass row, @Param("example") DtsClassExample example);

    int updateByExample(@Param("row") DtsClass row, @Param("example") DtsClassExample example);

    int updateByPrimaryKeySelective(DtsClass row);

    int updateByPrimaryKey(DtsClass row);
}