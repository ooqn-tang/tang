package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.DtsDataCount;

public interface DtsDataDao {
    DtsDataCount selectDataStatCount(String data);

    Integer selectDataType(String dataId);

    String selectDataAuthorId(String dataId);
}
