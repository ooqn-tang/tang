package com.ooqn.repository;

import com.ooqn.entity.dto.UtsFansDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.UtsFans;
import jakarta.transaction.Transactional;

@Transactional
public interface UtsFansRepository extends CrudRepository<UtsFans, String> {

    @Modifying
    int deleteByBeAuthorIdAndAuthorId(String authorId, String authorId1);

}
