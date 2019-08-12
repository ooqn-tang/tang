package com.jnnvc.vblog.service.impl;

import com.jnnvc.vblog.mapper.UserRoleMapper;
import com.jnnvc.vblog.entity.UserRole;
import com.jnnvc.vblog.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> listByUserId(String userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
