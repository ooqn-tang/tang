package net.ttcxy.service;

import net.ttcxy.entity.UserDto;

public interface AuthDetailsService {
    UserDto getUser();

    String getUserId();
}
