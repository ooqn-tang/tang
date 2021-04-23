package net.ttcxy.tang.gateway.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.gateway.entity.dto.UtsLoginDto;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsFansService {

    /**
     * @param authorId 粉丝名
     * @return 影响的行数
     */
    PageInfo<UtsAuthorDto> selectFansList(String authorId);

    /**
     * @param fansName 粉丝名
     * @return 影响的行数
     */
    int insertFans(String fansName);

    /**
     * @param fansName 粉丝名
     * @return 影响的行数
     */
    int deleteFans(String fansName);

}
