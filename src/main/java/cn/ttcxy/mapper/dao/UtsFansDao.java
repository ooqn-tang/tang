package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.UtsFansDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 粉丝
 */
public interface UtsFansDao {

    int selectFans(UtsFansDto utsFansDto);

    List<UtsFansDto> selectFansList(String userId);

    Integer isFans(String authorId, String beAuthorId);
}
