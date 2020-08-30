package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.gateway.entity.UserDto;

public interface AuthDetailsService {
    UserDto getUser();

    String getUserId();
}
