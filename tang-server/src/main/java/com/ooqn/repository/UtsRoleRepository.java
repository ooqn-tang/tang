package com.ooqn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.UtsRole;

public interface UtsRoleRepository extends CrudRepository<UtsRole, String> {

    List<UtsRole> findByRoleName(String roleName);

    @Query("From UtsRole where roleId in (select roleId from UtsAuthorRole where authorId = ?1)")
    List<UtsRole> findRoleListByAuthorId(String authorId);

    @Query("select roleId From UtsAuthorRole where authorId = ?1")
    List<String> findRoleIdList(String authorId);

}
