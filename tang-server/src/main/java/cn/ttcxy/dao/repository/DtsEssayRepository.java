package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.DtsEssay;

@NoRepositoryBean
public interface DtsEssayRepository extends CrudRepository<DtsEssay, String> {

}
