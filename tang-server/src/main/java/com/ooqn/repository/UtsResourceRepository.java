package com.ooqn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.dto.UtsRoleResourceDto;
import com.ooqn.entity.model.UtsResource;

public interface UtsResourceRepository extends CrudRepository<UtsResource, String> {

    List<UtsResource> findByNameLikeAndPathLike(String name, String path);

}
