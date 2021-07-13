package net.ttcxy.tang.service;

import net.ttcxy.tang.entity.model.UtsAuthor;

/**
 * 获取当前用户消息
 * @author huanglei
 */
public interface CurrentAuthorService {
    /**
     * 获取当前作者
     * @return LoginUser
     */
    UtsAuthor getAuthor();

    /**
     * 获取当前作者Id
     * @return user id
     */
    String getAuthorId();
}
