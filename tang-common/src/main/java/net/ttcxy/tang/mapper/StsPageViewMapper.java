package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.StsPageView;
import net.ttcxy.tang.model.StsPageViewExample;
import org.apache.ibatis.annotations.Param;

public interface StsPageViewMapper {
    long countByExample(StsPageViewExample example);

    int deleteByExample(StsPageViewExample example);

    int insert(StsPageView record);

    int insertSelective(StsPageView record);

    List<StsPageView> selectByExample(StsPageViewExample example);

    int updateByExampleSelective(@Param("record") StsPageView record, @Param("example") StsPageViewExample example);

    int updateByExample(@Param("record") StsPageView record, @Param("example") StsPageViewExample example);
}