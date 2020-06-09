package net.ttcxy.mapper;

import java.util.List;
import net.ttcxy.model.PageView;
import net.ttcxy.model.PageViewExample;
import org.apache.ibatis.annotations.Param;

public interface PageViewMapper {
    long countByExample(PageViewExample example);

    int deleteByExample(PageViewExample example);

    int deleteByPrimaryKey(String id);

    int insert(PageView record);

    int insertSelective(PageView record);

    List<PageView> selectByExample(PageViewExample example);

    PageView selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PageView record, @Param("example") PageViewExample example);

    int updateByExample(@Param("record") PageView record, @Param("example") PageViewExample example);

    int updateByPrimaryKeySelective(PageView record);

    int updateByPrimaryKey(PageView record);
}