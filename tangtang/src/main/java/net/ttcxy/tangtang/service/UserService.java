package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User selectUserByName(String name) ;

    int insertUser(String username,String password,String mail);

}
