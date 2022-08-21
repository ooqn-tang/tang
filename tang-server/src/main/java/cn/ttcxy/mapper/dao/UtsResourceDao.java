package cn.ttcxy.mapper.dao;

import java.util.List;

import cn.ttcxy.entity.dto.UtsRoleResourceDto;
import cn.ttcxy.entity.model.UtsResource;

/**
 * 资源
 */
public interface UtsResourceDao {

    List<UtsRoleResourceDto> selectAll();

    List<UtsResource> loadResourceUrlByRoleValue(String roleValue);

    List<String> selectByRoleId(String roleId);

}