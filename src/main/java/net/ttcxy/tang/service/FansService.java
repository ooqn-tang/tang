package net.ttcxy.tang.service;

import net.ttcxy.tang.entity.LoginUser;

import java.util.List;

public interface FansService {

    int selectFans(String fansName);

    int insertFans(String fansName);

    int deleteFans(String fansName);

    List<LoginUser> selectFansList(String userId);

}
