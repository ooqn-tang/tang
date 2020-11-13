package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.RoleDto;

import java.util.List;

/**
 * @author huanglei
 */
public interface RoleDao {
    List<RoleDto> selectRoleListByAuthorId(String authorId);
}
