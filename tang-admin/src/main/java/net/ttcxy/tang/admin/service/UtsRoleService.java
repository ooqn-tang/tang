package net.ttcxy.tang.admin.service;

import net.ttcxy.tang.admin.entity.dto.UtsRoleDto;
import net.ttcxy.tang.model.UtsRole;

import java.util.List;

/**
 * @author huanglei
 */
public interface UtsRoleService {

    /**
     * 获取所有的角色
     */
    List<UtsRole> getRoles();

    /**
     * 获取树形角色
     */
    List<UtsRoleDto> getTreeRoles();

    /**
     * 添加角色
     */
    int insertRole(UtsRole utsRole);

    /**
     * 更新角色
     */
    int updateRole(UtsRole utsRole);

    /**
     * 通过ID删除角色
     */
    int deleteRole(String id);

}
