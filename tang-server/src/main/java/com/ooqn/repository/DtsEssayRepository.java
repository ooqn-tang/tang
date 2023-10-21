package com.ooqn.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsEssay;

public interface DtsEssayRepository extends CrudRepository<DtsEssay, String> {

    Page<DtsEssay> findAll(Pageable pageable);

    Page<DtsEssay> findAllByOrderByCreateTimeDesc(Pageable pageable);

}
