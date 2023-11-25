package com.ooqn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ooqn.entity.model.UtsAuthorRole;

public interface UtsAuthorRoleRepository extends CrudRepository<UtsAuthorRole, String> {

    @Modifying
    @Transactional
    void deleteByAuthorId(String authorId);

    List<UtsAuthorRole> findByAuthorId(String authorId);
}
