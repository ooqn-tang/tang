package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsAdminState;
import net.ttcxy.tang.model.UtsAdminStateExample;
import org.apache.ibatis.annotations.Param;

public interface UtsAdminStateMapper {
    long countByExample(UtsAdminStateExample example);

    int deleteByExample(UtsAdminStateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UtsAdminState record);

    int insertSelective(UtsAdminState record);

    List<UtsAdminState> selectByExample(UtsAdminStateExample example);

    UtsAdminState selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UtsAdminState record, @Param("example") UtsAdminStateExample example);

    int updateByExample(@Param("record") UtsAdminState record, @Param("example") UtsAdminStateExample example);

    int updateByPrimaryKeySelective(UtsAdminState record);

    int updateByPrimaryKey(UtsAdminState record);
}