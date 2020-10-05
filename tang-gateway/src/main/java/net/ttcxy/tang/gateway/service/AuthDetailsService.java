package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.gateway.entity.LoginUser;

public interface AuthDetailsService {
    LoginUser getUser();

    String getUserId();
}
