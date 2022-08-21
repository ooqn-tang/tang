package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.entity.model.DtsEssayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsEssayMapper {
    long countByExample(DtsEssayExample example);

    int deleteByExample(DtsEssayExample example);

    int deleteByPrimaryKey(String essayId);

    int insert(DtsEssay row);

    int insertSelective(DtsEssay row);

    List<DtsEssay> selectByExample(DtsEssayExample example);

    DtsEssay selectByPrimaryKey(String essayId);

    int updateByExampleSelective(@Param("row") DtsEssay row, @Param("example") DtsEssayExample example);

    int updateByExample(@Param("row") DtsEssay row, @Param("example") DtsEssayExample example);

    int updateByPrimaryKeySelective(DtsEssay row);

    int updateByPrimaryKey(DtsEssay row);
}