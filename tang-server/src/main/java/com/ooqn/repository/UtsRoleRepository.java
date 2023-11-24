package com.ooqn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.UtsRole;

public interface UtsRoleRepository extends CrudRepository<UtsRole, String> {

    List<UtsRole> findByRoleName(String roleName);

    @Query("From UtsRole where roleId in (select roleId from UtsAuthorRole where authorId = ?1)")
    List<UtsRole> findRolesByAuthorId(String authorId);

    @Query("From UtsRole where roleId in (select roleId from UtsAuthorRole where authorId = (select authorId from UtsAuthor where username = ?1))")
    List<UtsRole> findRolesByUsername(String username);

    @Query("select roleId From UtsAuthorRole where authorId = ?1")
    List<String> findRoleIds(String authorId);

}
