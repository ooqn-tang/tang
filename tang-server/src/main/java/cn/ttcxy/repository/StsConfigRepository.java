package cn.ttcxy.repository;


import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.StsConfig;
import org.springframework.stereotype.Repository;

public interface StsConfigRepository extends CrudRepository<StsConfig, String> {

}
