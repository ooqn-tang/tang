package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.DtsMessage;

@Repository
public interface DtsMessageRepository extends CrudRepository<DtsMessage, String> {

}
