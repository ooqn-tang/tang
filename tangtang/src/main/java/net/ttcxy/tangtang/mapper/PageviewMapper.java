package net.ttcxy.tangtang.mapper;

import java.util.List;
import net.ttcxy.tangtang.model.Pageview;
import net.ttcxy.tangtang.model.PageviewExample;
import org.apache.ibatis.annotations.Param;

public interface PageviewMapper {
    long countByExample(PageviewExample example);

    int deleteByExample(PageviewExample example);

    int insert(Pageview record);

    int insertSelective(Pageview record);

    List<Pageview> selectByExample(PageviewExample example);

    int updateByExampleSelective(@Param("record") Pageview record, @Param("example") PageviewExample example);

    int updateByExample(@Param("record") Pageview record, @Param("example") PageviewExample example);
}