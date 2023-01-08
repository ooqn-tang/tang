package cn.ttcxy.dao.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.ttcxy.entity.model.DtsArticleSubject;

@NoRepositoryBean
public interface DtsArticleSubjectRepository extends CrudRepository<DtsArticleSubject, String> {

}
