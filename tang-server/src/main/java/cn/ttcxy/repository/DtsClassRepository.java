package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.DtsClass;

public interface DtsClassRepository extends CrudRepository<DtsClass, String> {

    List<DtsClass> findByType(String type);

}
