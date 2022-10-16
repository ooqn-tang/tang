package cn.ttcxy.mapper.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.DtsArticle;

@Repository
@Transactional
public interface DtsArticleRepository extends CrudRepository<DtsArticle, String> {

    void deleteByArticleIdAndAuthorId(String articleId, String authorId);

    List<DtsArticle> findAllBySubjectId(String subjectId);

    @Modifying
    @Query("update DtsArticle u set u.subjectId = ?1 where u.articleId = ?2") 
    Integer saveSubjectId(String subjectId,String articleId);
}
