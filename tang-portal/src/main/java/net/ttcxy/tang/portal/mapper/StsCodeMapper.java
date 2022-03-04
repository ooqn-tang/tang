package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.StsCode;
import net.ttcxy.tang.portal.entity.model.StsCodeExample;
import org.apache.ibatis.annotations.Param;

public interface StsCodeMapper {
    long countByExample(StsCodeExample example);

    int deleteByExample(StsCodeExample example);

    int deleteByPrimaryKey(Integer codeId);

    int insert(StsCode record);

    int insertSelective(StsCode record);

    List<StsCode> selectByExample(StsCodeExample example);

    StsCode selectByPrimaryKey(Integer codeId);

    int updateByExampleSelective(@Param("record") StsCode record, @Param("example") StsCodeExample example);

    int updateByExample(@Param("record") StsCode record, @Param("example") StsCodeExample example);

    int updateByPrimaryKeySelective(StsCode record);

    int updateByPrimaryKey(StsCode record);
}