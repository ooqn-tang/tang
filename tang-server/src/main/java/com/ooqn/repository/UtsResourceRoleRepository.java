package com.ooqn.repository;


import com.ooqn.entity.model.UtsResourceRole;
import org.springframework.data.repository.CrudRepository;

public interface UtsResourceRoleRepository extends CrudRepository<UtsResourceRole, String> {

    void deleteByRoleId(String roleId);
}
