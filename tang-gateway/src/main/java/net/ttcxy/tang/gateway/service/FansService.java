package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.gateway.entity.LoginUser;

import java.util.List;

/**
 * @author huanglei
 */
public interface FansService {

    /**
     * @param fansName 粉丝名
     * @return 影响的行数
     */
    int selectFans(String fansName);

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

    /**
     * @param userId user id
     * @return 登录用户
     */
    List<LoginUser> selectFansList(String userId);

}
