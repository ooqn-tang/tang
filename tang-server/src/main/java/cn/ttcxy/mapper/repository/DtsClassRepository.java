package cn.ttcxy.mapper.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.DtsClass;

@Repository
public interface DtsClassRepository extends CrudRepository<DtsClass, String> {

}
