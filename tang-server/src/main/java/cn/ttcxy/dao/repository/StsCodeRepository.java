package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.StsCode;

@Repository
public interface StsCodeRepository extends CrudRepository<StsCode, String> {

}
