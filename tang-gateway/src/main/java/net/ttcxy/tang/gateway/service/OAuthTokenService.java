package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.code.exception.ErrorCodeException;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.model.UtsAuthor;

public interface OAuthTokenService {

    /**
     *  传入Code 如果用户存在返回用户信息，不存在，创建用户
     * @param code 登录TOKEN
     */
    UtsAuthorLogin loadAuthor(String code) throws ErrorCodeException;

    /**
     * 通过GithubId 创建用户
     */
    UtsAuthor createAuthorAndGithubLogin(String githubId, String host);
}
