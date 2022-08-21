package cn.ttcxy.mapper.dao;

import java.util.List;

import cn.ttcxy.entity.dto.UtsFansDto;

/**
 * 粉丝
 */
public interface UtsFansDao {

    int selectFans(UtsFansDto utsFansDto);

    List<UtsFansDto> selectFansList(String userId);

    Integer isFans(String authorId, String beAuthorId);
}
