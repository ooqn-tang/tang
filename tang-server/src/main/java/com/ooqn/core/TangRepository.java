package com.ooqn.core;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TangRepository <T, ID> extends CrudRepository<T, ID> {

   Page<T> findPageByAll();

   List<T> findAllById(Iterable<ID> ids);

}
