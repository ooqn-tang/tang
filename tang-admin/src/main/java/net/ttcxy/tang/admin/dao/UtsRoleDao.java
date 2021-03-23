package net.ttcxy.tang.admin.dao;

import net.ttcxy.tang.admin.entity.dto.UtsRoleDto;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsRoleDao {
    List<UtsRoleDto> selectRoleListByMemberId(String authorId);

    List<UtsRoleDto> getTreeRoles();
}
