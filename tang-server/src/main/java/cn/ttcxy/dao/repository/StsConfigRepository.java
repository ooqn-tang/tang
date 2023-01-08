package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.StsConfig;

@NoRepositoryBean
public interface StsConfigRepository extends CrudRepository<StsConfig, String> {

}
