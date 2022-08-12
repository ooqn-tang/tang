package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsDataCount;
import org.apache.ibatis.annotations.Param;

/**
 * 同时获取视频，博客
 */
public interface DtsDataDao {

    DtsDataCount selectDataStatCount(String dataId);

    Integer selectDataType(String dataId);

    String selectDataAuthorId(String dataId);

}
