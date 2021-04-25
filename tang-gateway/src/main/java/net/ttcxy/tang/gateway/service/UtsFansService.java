package net.ttcxy.tang.gateway.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.entity.dto.UtsFansDto;
import net.ttcxy.tang.gateway.entity.model.UtsFans;

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
     * @param fansId 粉丝名
     * @param authorId
     * @return 影响的行数
     */
    int deleteFans(String fansId,String authorId);

}
