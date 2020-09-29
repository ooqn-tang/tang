package net.ttcxy.tang.db.mapper;

import java.util.List;
import net.ttcxy.tang.entity.model.PageView;
import net.ttcxy.tang.entity.model.PageViewExample;
import org.apache.ibatis.annotations.Param;

public interface PageViewMapper {
    long countByExample(PageViewExample example);

    int deleteByExample(PageViewExample example);

    int insert(PageView record);

    int insertSelective(PageView record);

    List<PageView> selectByExample(PageViewExample example);

    int updateByExampleSelective(@Param("record") PageView record, @Param("example") PageViewExample example);

    int updateByExample(@Param("record") PageView record, @Param("example") PageViewExample example);
}