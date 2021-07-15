package net.ttcxy.tang.portal.dao.mapper;

import net.ttcxy.tang.portal.entity.model.StsConfig;
import net.ttcxy.tang.portal.entity.model.StsConfigExample;
import org.apache.ibatis.annotations.Param;

public interface StsConfigMapper {
    long countByExample(StsConfigExample example);

    int deleteByExample(StsConfigExample example);

    int deleteByPrimaryKey(String configId);

    int insert(StsConfig record);

    int insertSelective(StsConfig record);

    StsConfig selectByPrimaryKey(String configId);

    int updateByExampleSelective(@Param("record") StsConfig record, @Param("example") StsConfigExample example);

    int updateByExample(@Param("record") StsConfig record, @Param("example") StsConfigExample example);

    int updateByPrimaryKeySelective(StsConfig record);

    int updateByPrimaryKey(StsConfig record);
}