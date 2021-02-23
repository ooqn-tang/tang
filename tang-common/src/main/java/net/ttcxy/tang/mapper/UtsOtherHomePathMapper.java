package net.ttcxy.tang.mapper;

import java.util.List;
import net.ttcxy.tang.model.UtsOtherHomePath;
import net.ttcxy.tang.model.UtsOtherHomePathExample;
import org.apache.ibatis.annotations.Param;

public interface UtsOtherHomePathMapper {
    long countByExample(UtsOtherHomePathExample example);

    int deleteByExample(UtsOtherHomePathExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(UtsOtherHomePath record);

    int insertSelective(UtsOtherHomePath record);

    List<UtsOtherHomePath> selectByExample(UtsOtherHomePathExample example);

    UtsOtherHomePath selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") UtsOtherHomePath record, @Param("example") UtsOtherHomePathExample example);

    int updateByExample(@Param("record") UtsOtherHomePath record, @Param("example") UtsOtherHomePathExample example);

    int updateByPrimaryKeySelective(UtsOtherHomePath record);

    int updateByPrimaryKey(UtsOtherHomePath record);
}