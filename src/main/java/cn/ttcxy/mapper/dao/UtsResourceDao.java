package cn.ttcxy.mapper.dao;

import cn.ttcxy.entity.dto.UtsRoleResourceDto;
import cn.ttcxy.entity.model.UtsResource;

import java.util.List;

public interface UtsResourceDao {
    List<UtsRoleResourceDto> selectAll();

    List<UtsResource> loadResourceUrlByRoleValue(String roleValue);

    List<String> selectByRoleId(String roleId);
}