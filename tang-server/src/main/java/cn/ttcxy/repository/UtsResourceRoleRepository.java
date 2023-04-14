package cn.ttcxy.repository;


import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.UtsResourceRole;

public interface UtsResourceRoleRepository extends CrudRepository<UtsResourceRole, String> {

    void deleteByRoleId(String roleId);
}
