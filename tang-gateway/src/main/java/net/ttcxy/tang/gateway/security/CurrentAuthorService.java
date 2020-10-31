package net.ttcxy.tang.gateway.security;

import net.ttcxy.tang.gateway.entity.AuthorLogin;

/**
 * 获取当前用户消息
 * @author huanglei
 */
public interface CurrentAuthorService {
    /**
     * 获取当前作者
     * @return LoginUser
     */
    AuthorLogin getAuthor();

    /**
     * 获取当前作者Id
     * @return user id
     */
    String getAuthorId();
}
