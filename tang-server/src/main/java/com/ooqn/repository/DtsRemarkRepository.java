package com.ooqn.repository;

import com.ooqn.entity.model.DtsRemark;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DtsRemarkRepository extends CrudRepository<DtsRemark , String>{

    Page<DtsRemark> findByDataIdOrderByCreateTimeDesc(String dataId, Pageable pageable);
    
}
