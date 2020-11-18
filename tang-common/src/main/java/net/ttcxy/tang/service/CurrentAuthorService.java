package net.ttcxy.tang.service;

import net.ttcxy.tang.entity.UtsAuthorLogin;

/**
 * 获取当前用户消息
 * @author huanglei
 */
public interface CurrentAuthorService {
    /**
     * 获取当前作者
     * @return LoginUser
     */
    UtsAuthorLogin getAuthor();

    /**
     * 获取当前作者Id
     * @return user id
     */
    String getAuthorId();
}
