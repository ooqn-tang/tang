package com.jnnvc.vblog.service;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.Map;

public interface PermissionService {

    Map<String, Collection<ConfigAttribute>> getPermissionMap();
}
