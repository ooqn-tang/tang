package com.jnnvc.vblog.service;

import com.jnnvc.vblog.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRoleService {

    List<UserRole> listByUserId(String id);
}
