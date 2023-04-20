package com.ooqn.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsClass;

public interface DtsClassRepository extends CrudRepository<DtsClass, String> {

    List<DtsClass> findByType(String type);

}
