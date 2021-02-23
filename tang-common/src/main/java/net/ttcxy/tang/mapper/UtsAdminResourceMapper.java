package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsAdminResource;
import net.ttcxy.tang.model.UtsAdminResourceExample;
import org.apache.ibatis.annotations.Param;

public interface UtsAdminResourceMapper {
    long countByExample(UtsAdminResourceExample example);

    int deleteByExample(UtsAdminResourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsAdminResource record);

    int insertSelective(UtsAdminResource record);

    List<UtsAdminResource> selectByExample(UtsAdminResourceExample example);

    UtsAdminResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsAdminResource record, @Param("example") UtsAdminResourceExample example);

    int updateByExample(@Param("record") UtsAdminResource record, @Param("example") UtsAdminResourceExample example);

    int updateByPrimaryKeySelective(UtsAdminResource record);

    int updateByPrimaryKey(UtsAdminResource record);
}