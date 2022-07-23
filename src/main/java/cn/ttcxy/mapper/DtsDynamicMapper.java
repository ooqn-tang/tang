package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsDynamic;
import cn.ttcxy.entity.model.DtsDynamicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsDynamicMapper {
    long countByExample(DtsDynamicExample example);

    int deleteByExample(DtsDynamicExample example);

    int deleteByPrimaryKey(String dynamicId);

    int insert(DtsDynamic row);

    int insertSelective(DtsDynamic row);

    List<DtsDynamic> selectByExample(DtsDynamicExample example);

    DtsDynamic selectByPrimaryKey(String dynamicId);

    int updateByExampleSelective(@Param("row") DtsDynamic row, @Param("example") DtsDynamicExample example);

    int updateByExample(@Param("row") DtsDynamic row, @Param("example") DtsDynamicExample example);

    int updateByPrimaryKeySelective(DtsDynamic row);

    int updateByPrimaryKey(DtsDynamic row);
}