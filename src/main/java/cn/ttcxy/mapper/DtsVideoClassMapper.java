package cn.ttcxy.mapper;

import java.util.List;
import cn.ttcxy.entity.model.DtsVideoClass;
import cn.ttcxy.entity.model.DtsVideoClassExample;
import org.apache.ibatis.annotations.Param;

public interface DtsVideoClassMapper {
    long countByExample(DtsVideoClassExample example);

    int deleteByExample(DtsVideoClassExample example);

    int deleteByPrimaryKey(String videoClassId);

    int insert(DtsVideoClass record);

    int insertSelective(DtsVideoClass record);

    List<DtsVideoClass> selectByExample(DtsVideoClassExample example);

    DtsVideoClass selectByPrimaryKey(String videoClassId);

    int updateByExampleSelective(@Param("record") DtsVideoClass record, @Param("example") DtsVideoClassExample example);

    int updateByExample(@Param("record") DtsVideoClass record, @Param("example") DtsVideoClassExample example);

    int updateByPrimaryKeySelective(DtsVideoClass record);

    int updateByPrimaryKey(DtsVideoClass record);
}