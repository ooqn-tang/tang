package com.ooqn.repository;


import com.ooqn.entity.model.UtsResourceRole;
import org.springframework.data.repository.CrudRepository;

/**
 * 资源于角色的关联相关
 */
public interface UtsResourceRoleRepository extends CrudRepository<UtsResourceRole, String> {

    /**
     * 删除当前角色所有资源
     */
    void deleteByRoleId(String roleId);
}
