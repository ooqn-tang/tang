package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.DtsEssay;

@Repository
public interface DtsEssayRepository extends CrudRepository<DtsEssay, String> {

}
