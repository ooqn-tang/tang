package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDto selectUserByName(String name) ;

    Boolean insertUser(UserDto userDto);

    int updateUser(UserDto userDto);

    Boolean updateUserPassword(UserDto userDto);

    Boolean selectUsernameIsTrue(String username);

    Boolean selectMailIsTrue(String username);

    Boolean updateUserByMail(String mail,String password);

    List<UserDto> listUser();
}
