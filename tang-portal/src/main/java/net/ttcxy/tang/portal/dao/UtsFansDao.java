package net.ttcxy.tang.portal.dao;

import net.ttcxy.tang.portal.entity.dto.UtsFansDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 粉丝
 * @author huanglei
 */
public interface UtsFansDao {


    /**
     * 查询是否为粉丝
     * @param utsFansDto 粉丝
     * @return 查询的行数
     */
    int selectFans(UtsFansDto utsFansDto);

    /**
     * 添加粉丝
     * @param utsFansDto 粉丝
     * @return 影响的行数
     */
    int insertFans(UtsFansDto utsFansDto);

    /**
     * 删除粉丝
     * @param utsFansDto 粉丝
     * @return 影响的行数
     */
    int deleteFans(UtsFansDto utsFansDto);

    /**
     * 通过用户ID出现粉丝列表
     * @param userId id
     * @return 粉丝列表
     */
    List<UtsFansDto> selectFansList(@Param("authorId") String userId);

    /**
     * 查询关注是否存在
     * @param authorId 关注者ID
     * @param beAuthorId 被关注者ID
     * @return count
     */
    Integer isFans(String authorId, String beAuthorId);
}
