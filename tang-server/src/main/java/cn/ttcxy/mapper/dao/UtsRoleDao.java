package cn.ttcxy.mapper.dao;

import java.util.List;

import cn.ttcxy.entity.dto.UtsRoleDto;

/**
 * 角色
 */
public interface UtsRoleDao {

    List<UtsRoleDto> selectRoleListByAuthorId(String authorId);

    List<String> selectRoleIdList(String authorId);

}
