package cn.ttcxy.repository;


import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.StsCode;
import org.springframework.stereotype.Repository;

public interface StsCodeRepository extends CrudRepository<StsCode, String> {

}
