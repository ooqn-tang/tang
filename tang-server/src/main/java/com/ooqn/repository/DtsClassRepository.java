package com.ooqn.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsCategory;

public interface DtsClassRepository extends CrudRepository<DtsCategory, String> {

    List<DtsCategory> findByType(String type);

    List<DtsCategory> findByTypeOrderByOrderNum(String type);

    List<DtsCategory> findByParentIdOrderByOrderNum(String parentId);

}
