package net.ttcxy.tang.admin.service;


import net.ttcxy.tang.admin.entity.UtsMemberLogin;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsFansService {

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
    List<UtsMemberLogin> selectFansList(String userId);

}
