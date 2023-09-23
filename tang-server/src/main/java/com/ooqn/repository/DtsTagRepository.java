package com.ooqn.repository;

import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsTag;

public interface DtsTagRepository  extends CrudRepository<DtsTag, String> {
    
}
