package com.jnnvc.vblog.mapper;

import com.jnnvc.vblog.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    @Select("SELECT * FROM user_role WHERE user_id = #{userId}")
    List<UserRole> listByUserId(String userId);

}
