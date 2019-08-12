package com.jnnvc.vblog.service.impl;

import com.jnnvc.vblog.mapper.RoleMapper;
import com.jnnvc.vblog.entity.Role;
import com.jnnvc.vblog.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    RoleMapper roleMapper;

    @Override
    public Role selectById(String id) {
        return roleMapper.selectById(id);
    }
}
