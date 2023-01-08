package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.DtsMessage;

@NoRepositoryBean
public interface DtsMessageRepository extends CrudRepository<DtsMessage, String> {

}
