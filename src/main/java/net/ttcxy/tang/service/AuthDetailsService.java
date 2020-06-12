package net.ttcxy.tang.service;

import net.ttcxy.tang.entity.UserDto;

public interface AuthDetailsService {
    UserDto getUser();

    String getUserId();
}
