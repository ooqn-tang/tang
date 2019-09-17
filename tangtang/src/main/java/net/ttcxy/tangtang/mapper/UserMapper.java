package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from entity_user where username = #{username}")
    User selectUserByName(String username);

}
