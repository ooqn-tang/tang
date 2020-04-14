package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.dto.User;

public interface UserMapper {

    int selectEmailIsTrue(String mail);

    User selectUserByName(String username);

    int insertUser(User user);

    int updateUser(User user);

    int updateUserPassword(User user);
}
