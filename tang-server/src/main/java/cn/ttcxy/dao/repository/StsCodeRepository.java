package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.StsCode;

@NoRepositoryBean
public interface StsCodeRepository extends CrudRepository<StsCode, String> {

}
