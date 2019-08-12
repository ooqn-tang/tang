package com.jnnvc.vblog.mapper;

import com.jnnvc.vblog.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User selectUserByName(String username);

}
