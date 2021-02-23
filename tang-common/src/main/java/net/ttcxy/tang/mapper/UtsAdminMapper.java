package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsAdmin;
import net.ttcxy.tang.model.UtsAdminExample;
import org.apache.ibatis.annotations.Param;

public interface UtsAdminMapper {
    long countByExample(UtsAdminExample example);

    int deleteByExample(UtsAdminExample example);

    int deleteByPrimaryKey(String id);

    int insert(UtsAdmin record);

    int insertSelective(UtsAdmin record);

    List<UtsAdmin> selectByExample(UtsAdminExample example);

    UtsAdmin selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UtsAdmin record, @Param("example") UtsAdminExample example);

    int updateByExample(@Param("record") UtsAdmin record, @Param("example") UtsAdminExample example);

    int updateByPrimaryKeySelective(UtsAdmin record);

    int updateByPrimaryKey(UtsAdmin record);
}