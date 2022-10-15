package cn.ttcxy.mapper.repository;


import cn.ttcxy.entity.model.DtsArticleContent;
import cn.ttcxy.entity.model.UtsAuthorRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtsAuthorRoleRepository extends CrudRepository<UtsAuthorRole, String> {

    long deleteByAuthorId(String authorId);
}
