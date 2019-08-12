package com.jnnvc.vblog.service.impl;

import com.jnnvc.vblog.mapper.PermissionMapper;
import com.jnnvc.vblog.service.PermissionService;
import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.Map;

public class PermissionServiceImpl implements PermissionService {

    PermissionMapper permissionMapper;

    @Override
    public Map<String, Collection<ConfigAttribute>> getPermissionMap() {
        return null;
    }
}
