package net.ttcxy.tang.gateway.dao.mapper;

import java.util.List;
import net.ttcxy.tang.gateway.entity.model.UtsFile;
import net.ttcxy.tang.gateway.entity.model.UtsFileExample;
import org.apache.ibatis.annotations.Param;

public interface UtsFileMapper {
    long countByExample(UtsFileExample example);

    int deleteByExample(UtsFileExample example);

    int deleteByPrimaryKey(Integer fileId);

    int insert(UtsFile record);

    int insertSelective(UtsFile record);

    List<UtsFile> selectByExample(UtsFileExample example);

    UtsFile selectByPrimaryKey(Integer fileId);

    int updateByExampleSelective(@Param("record") UtsFile record, @Param("example") UtsFileExample example);

    int updateByExample(@Param("record") UtsFile record, @Param("example") UtsFileExample example);

    int updateByPrimaryKeySelective(UtsFile record);

    int updateByPrimaryKey(UtsFile record);
}