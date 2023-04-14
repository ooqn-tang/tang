package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.DtsClass;

public interface DtsClassRepository extends CrudRepository<DtsClass, String> {

    @Query(value="""
    select * 
    from dts_class where type = ?1
    """,nativeQuery = true)
    List<DtsClass> selectClass(String type);

}
