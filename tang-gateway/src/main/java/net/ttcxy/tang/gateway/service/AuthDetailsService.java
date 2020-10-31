package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.gateway.entity.LoginUser;

/**
 * 获取当前用户消息
 * @author huanglei
 */
public interface AuthDetailsService {
    /**
     * 获取在线用户
     * @return LoginUser
     */
    LoginUser getUser();

    /**
     * 获取当前用户Id
     * @return user id
     */
    String getUserId();
}
