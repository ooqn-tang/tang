package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.DtsClass;

@NoRepositoryBean
public interface DtsClassRepository extends CrudRepository<DtsClass, String> {

}
