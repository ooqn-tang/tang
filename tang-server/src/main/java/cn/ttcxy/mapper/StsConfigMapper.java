package cn.ttcxy.mapper;

import cn.ttcxy.entity.model.StsConfig;
import cn.ttcxy.entity.model.StsConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StsConfigMapper {
    long countByExample(StsConfigExample example);

    int deleteByExample(StsConfigExample example);

    int deleteByPrimaryKey(String configId);

    int insert(StsConfig row);

    int insertSelective(StsConfig row);

    List<StsConfig> selectByExample(StsConfigExample example);

    StsConfig selectByPrimaryKey(String configId);

    int updateByExampleSelective(@Param("row") StsConfig row, @Param("example") StsConfigExample example);

    int updateByExample(@Param("row") StsConfig row, @Param("example") StsConfigExample example);

    int updateByPrimaryKeySelective(StsConfig row);

    int updateByPrimaryKey(StsConfig row);
}