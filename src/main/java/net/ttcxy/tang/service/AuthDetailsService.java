package net.ttcxy.tang.service;

import net.ttcxy.tang.entity.LoginUser;

public interface AuthDetailsService {
    LoginUser getUser();

    String getUserId();
}
