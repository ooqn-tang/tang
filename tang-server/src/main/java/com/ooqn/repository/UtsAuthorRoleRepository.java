package com.ooqn.repository;


import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.UtsAuthorRole;

public interface UtsAuthorRoleRepository extends CrudRepository<UtsAuthorRole, String> {

    void deleteByAuthorId(String authorId);
}
