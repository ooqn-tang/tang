package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.StsCode;
import cn.ttcxy.entity.model.StsCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StsCodeMapper {
    long countByExample(StsCodeExample example);

    int deleteByExample(StsCodeExample example);

    int deleteByPrimaryKey(Integer codeId);

    int insert(StsCode row);

    int insertSelective(StsCode row);

    List<StsCode> selectByExample(StsCodeExample example);

    StsCode selectByPrimaryKey(Integer codeId);

    int updateByExampleSelective(@Param("row") StsCode row, @Param("example") StsCodeExample example);

    int updateByExample(@Param("row") StsCode row, @Param("example") StsCodeExample example);

    int updateByPrimaryKeySelective(StsCode row);

    int updateByPrimaryKey(StsCode row);
}