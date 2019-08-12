package com.jnnvc.vblog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.access.ConfigAttribute;

import java.util.List;
import java.util.Map;

@Mapper
public interface PermissionMapper {

    @Select("select url,qx from permission")
    Map<String, List<String>> getPermissionMap();

}
