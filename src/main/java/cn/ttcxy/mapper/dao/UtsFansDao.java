package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.UtsFansDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 粉丝
 */
public interface UtsFansDao {

    int selectFans(UtsFansDto utsFansDto);

    int insertFans(UtsFansDto utsFansDto);

    int deleteFans(UtsFansDto utsFansDto);

    List<UtsFansDto> selectFansList(@Param("authorId") String userId);

    Integer isFans(@Param("authorId") String authorId, @Param("beAuthorId") String beAuthorId);
}
