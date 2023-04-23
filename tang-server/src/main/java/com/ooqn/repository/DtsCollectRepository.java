package com.ooqn.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsCollect;

import jakarta.transaction.Transactional;

@Transactional
public interface DtsCollectRepository extends CrudRepository<DtsCollect, String> {

    long countByDataIdAndAuthorId(String dataId, String authorId);

    Page<DtsCollect> findByAuthorId(String authorId, Pageable pageable);

}
