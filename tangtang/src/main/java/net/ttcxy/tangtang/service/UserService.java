package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User selectUserByName(String name) ;

    Boolean insertUser(User user);

    int updateUser(User user);

    Boolean updateUserPassword(User user);

    Boolean selectUsernameIsTrue(String username);

    Boolean selectMailIsTrue(String username);

    Boolean updateUserByMail(String mail,String password);
}
