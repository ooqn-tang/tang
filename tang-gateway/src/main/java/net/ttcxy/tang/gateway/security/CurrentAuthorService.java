package net.ttcxy.tang.gateway.security;

import net.ttcxy.tang.gateway.entity.AuthorLogin;

/**
 * 获取当前用户消息
 * @author huanglei
 */
public interface CurrentAuthorService {
    /**
     * 获取在线用户
     * @return LoginUser
     */
    AuthorLogin getUser();

    /**
     * 获取当前用户Id
     * @return user id
     */
    String getUserId();
}
