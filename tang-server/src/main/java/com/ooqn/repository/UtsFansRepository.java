package com.ooqn.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.UtsFans;

import jakarta.transaction.Transactional;

@Transactional
public interface UtsFansRepository extends CrudRepository<UtsFans, String> {

    @Modifying
    int deleteByBeAuthorIdAndAuthorId(String authorId, String authorId1);

}
