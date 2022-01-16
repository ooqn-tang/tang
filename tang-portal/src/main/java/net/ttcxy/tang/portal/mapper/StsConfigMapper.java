package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.StsConfig;
import net.ttcxy.tang.portal.entity.model.StsConfigExample;
import org.apache.ibatis.annotations.Param;

public interface StsConfigMapper {
    long countByExample(StsConfigExample example);

    int deleteByExample(StsConfigExample example);

    int deleteByPrimaryKey(String configId);

    int insert(StsConfig record);

    int insertSelective(StsConfig record);

    List<StsConfig> selectByExample(StsConfigExample example);

    StsConfig selectByPrimaryKey(String configId);

    int updateByExampleSelective(@Param("record") StsConfig record, @Param("example") StsConfigExample example);

    int updateByExample(@Param("record") StsConfig record, @Param("example") StsConfigExample example);

    int updateByPrimaryKeySelective(StsConfig record);

    int updateByPrimaryKey(StsConfig record);
}