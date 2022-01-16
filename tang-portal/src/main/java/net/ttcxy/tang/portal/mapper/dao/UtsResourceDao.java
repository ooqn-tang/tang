package net.ttcxy.tang.portal.mapper.dao;

import net.ttcxy.tang.portal.entity.dto.UtsRoleResourceDto;
import net.ttcxy.tang.portal.entity.model.UtsResource;

import java.util.List;

public interface UtsResourceDao {
    List<UtsRoleResourceDto> selectAll();

    List<String> loadResourceUrlByRoleValue(String roleValue);

    List<String> selectByRoleId(String roleId);
}