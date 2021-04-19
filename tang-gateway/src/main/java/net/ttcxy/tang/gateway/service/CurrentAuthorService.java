package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.gateway.entity.dto.UtsLoginDto;

/**
 * 获取当前用户消息
 * @author huanglei
 */
public interface CurrentAuthorService {
    /**
     * 获取当前作者
     * @return LoginUser
     */
    UtsLoginDto getAuthor();

    /**
     * 获取当前作者Id
     * @return user id
     */
    String getAuthorId();
}
