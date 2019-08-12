package com.jnnvc.vblog.service;

import com.jnnvc.vblog.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User selectUserByName(String name) ;

}
