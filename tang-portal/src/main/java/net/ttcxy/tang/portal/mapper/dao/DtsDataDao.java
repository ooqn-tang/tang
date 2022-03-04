package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.DtsDataCount;

public interface DtsDataDao {
    DtsDataCount selectDataStatCount(String data);

    Integer selectDataType(String dataId);

    String selectDataAuthorId(String dataId);
}
