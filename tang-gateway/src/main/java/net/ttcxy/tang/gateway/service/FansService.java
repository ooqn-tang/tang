package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.gateway.entity.LoginUser;

import java.util.List;

public interface FansService {

    int selectFans(String fansName);

    int insertFans(String fansName);

    int deleteFans(String fansName);

    List<LoginUser> selectFansList(String userId);

}
