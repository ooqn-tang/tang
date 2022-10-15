package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.DtsComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DtsCommentRepository extends CrudRepository<DtsComment, String> {

}
