package net.ttcxy.tang.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.entity.dto.UtsFansDto;
import net.ttcxy.tang.entity.model.UtsFans;

/**
 * @author huanglei
 */
public interface UtsFansService {

    /**
     * @param authorId 粉丝名
     * @return 影响的行数
     */
    PageInfo<UtsFansDto> selectFansList(String authorId);

    /**
     * @param fans 粉丝名
     * @return 影响的行数
     */
    int insertFans(UtsFans fans);

    /**
     * @param fansName 粉丝名
     * @param authorId
     * @return 影响的行数
     */
    int deleteFans(String fansName,String authorId);

    Integer isFans(String authorId, String username);
}
