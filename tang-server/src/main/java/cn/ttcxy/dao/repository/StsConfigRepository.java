package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.StsConfig;

@Repository
public interface StsConfigRepository extends CrudRepository<StsConfig, String> {

}
