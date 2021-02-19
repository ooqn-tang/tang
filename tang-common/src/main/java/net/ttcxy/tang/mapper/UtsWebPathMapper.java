package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsWebPath;
import net.ttcxy.tang.model.UtsWebPathExample;
import org.apache.ibatis.annotations.Param;

public interface UtsWebPathMapper {
    long countByExample(UtsWebPathExample example);

    int deleteByExample(UtsWebPathExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(UtsWebPath record);

    int insertSelective(UtsWebPath record);

    List<UtsWebPath> selectByExample(UtsWebPathExample example);

    UtsWebPath selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") UtsWebPath record, @Param("example") UtsWebPathExample example);

    int updateByExample(@Param("record") UtsWebPath record, @Param("example") UtsWebPathExample example);

    int updateByPrimaryKeySelective(UtsWebPath record);

    int updateByPrimaryKey(UtsWebPath record);
}