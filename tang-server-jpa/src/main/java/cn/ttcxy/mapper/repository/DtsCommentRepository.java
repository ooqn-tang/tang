package cn.ttcxy.mapper.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.DtsComment;

@Repository
public interface DtsCommentRepository extends CrudRepository<DtsComment, String> {

}
