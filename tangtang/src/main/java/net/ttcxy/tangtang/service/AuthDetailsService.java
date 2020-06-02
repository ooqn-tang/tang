package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.UserDto;

public interface AuthDetailsService {
    UserDto getUser();

    String getUserId();
}
