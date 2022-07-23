package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.entity.model.DtsDynamicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsEssayMapper {
    long countByExample(DtsDynamicExample example);

    int deleteByExample(DtsDynamicExample example);

    int deleteByPrimaryKey(String dynamicId);

    int insert(DtsEssay row);

    int insertSelective(DtsEssay row);

    List<DtsEssay> selectByExample(DtsDynamicExample example);

    DtsEssay selectByPrimaryKey(String dynamicId);

    int updateByExampleSelective(@Param("row") DtsEssay row, @Param("example") DtsDynamicExample example);

    int updateByExample(@Param("row") DtsEssay row, @Param("example") DtsDynamicExample example);

    int updateByPrimaryKeySelective(DtsEssay row);

    int updateByPrimaryKey(DtsEssay row);
}