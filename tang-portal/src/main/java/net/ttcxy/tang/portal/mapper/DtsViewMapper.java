package net.ttcxy.tang.portal.mapper;

import java.util.List;
import net.ttcxy.tang.portal.entity.model.DtsView;
import net.ttcxy.tang.portal.entity.model.DtsViewExample;
import org.apache.ibatis.annotations.Param;

public interface DtsViewMapper {
    long countByExample(DtsViewExample example);

    int deleteByExample(DtsViewExample example);

    int deleteByPrimaryKey(String viewId);

    int insert(DtsView record);

    int insertSelective(DtsView record);

    List<DtsView> selectByExample(DtsViewExample example);

    DtsView selectByPrimaryKey(String viewId);

    int updateByExampleSelective(@Param("record") DtsView record, @Param("example") DtsViewExample example);

    int updateByExample(@Param("record") DtsView record, @Param("example") DtsViewExample example);

    int updateByPrimaryKeySelective(DtsView record);

    int updateByPrimaryKey(DtsView record);
}