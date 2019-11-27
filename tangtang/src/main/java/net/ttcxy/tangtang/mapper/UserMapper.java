package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    User selectUserByName(String username);

    int insertUser(User user);

}
