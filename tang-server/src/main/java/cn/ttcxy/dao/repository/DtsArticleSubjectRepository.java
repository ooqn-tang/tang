package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.DtsArticleSubject;

@Repository
public interface DtsArticleSubjectRepository extends CrudRepository<DtsArticleSubject, String> {

}
