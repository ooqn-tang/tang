package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleSubject;

public interface DtsArticleSubjectRepository extends CrudRepository<DtsArticleSubject, String> {

	@Query(value="select * from dts_article_subject",nativeQuery = true)
    public DtsArticleSubjectDto findSubjectById(String subjectId);

	@Query(value="select * from dts_article_subject",nativeQuery = true)
	public Page<DtsArticleSubjectDto> findSubjectList(Pageable pageable);

	@Query(value="select * from dts_article_subject ?1",nativeQuery = true)
	public List<DtsArticleSubjectDto> findSubjectListByUsername(String username) ;

	@Query(value="select * from dts_article_subject",nativeQuery = true)
	public Page<DtsArticleSubjectDto> findSubjectListBySubjectName(String name, Pageable pageable) ;

	@Query(value="select * from dts_article_subject t1,dts_article_subject_relevance t2 where t1.subject_id = t2.subject_id and t2.article_id = ?1",nativeQuery = true)
	public String findSubjectIdByArticleId(String articleId) ;

	@Query(value="select * from dts_article_subject",nativeQuery = true)
	public List<DtsArticle> findAllBySubjectId(String subjectId) ;

	@Query(value="select * from dts_article_subject",nativeQuery = true)
	public List<DtsArticle> findSubjectArticleTitleListBySubjectId(String subjectId) ;

	@Query(value="select * from dts_article_subject",nativeQuery = true)
	public void deleteBySubjectIdAndAuthorId(String subjectId, String authorId);
}
