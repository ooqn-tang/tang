package net.ttcxy.tang.service;

import net.ttcxy.tang.entity.UserDto;

import java.util.List;

public interface FansService {

    int selectFans(String fansName);

    int insertFans(String fansName);

    int deleteFans(String fansName);

    List<UserDto> selectFansList(String userId);

}
