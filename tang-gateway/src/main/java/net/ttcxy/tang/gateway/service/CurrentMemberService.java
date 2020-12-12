package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.gateway.entity.UtsMemberLogin;

/**
 * 获取当前用户消息
 * @author huanglei
 */
public interface CurrentMemberService {
    /**
     * 获取当前作者
     * @return LoginUser
     */
    UtsMemberLogin getMember();

    /**
     * 获取当前作者Id
     * @return user id
     */
    String getMemberId();
}
