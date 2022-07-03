package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsDataCount;
import org.apache.ibatis.annotations.Param;

/**
 * 同时获取视频，博客
 */
public interface DtsDataDao {

    DtsDataCount selectDataStatCount(@Param("dataId") String dataId);

    Integer selectDataType(@Param("dataId") String dataId);

    String selectDataAuthorId(@Param("dataId") String dataId);

}
