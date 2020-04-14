package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.dto.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User selectUserByName(String name) ;

    int insertUser(String username,String password,String mail);

    int updateUser(User user);

    int updateUserPassword(User user);
}
