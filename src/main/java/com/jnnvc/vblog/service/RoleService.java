package com.jnnvc.vblog.service;

import com.jnnvc.vblog.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {

    Role selectById(String id);

}
