package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsDataCount;
import org.apache.ibatis.annotations.Param;

public interface DtsDataDao {

    DtsDataCount selectDataStatCount(@Param("dataId") String dataId);

    Integer selectDataType(@Param("dataId") String dataId);

    String selectDataAuthorId(@Param("dataId") String dataId);

}
