package cn.ttcxy.repository;


import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;

public interface DtsArticleRepository extends CrudRepository<DtsArticle, String> {

    @Query(value="select * from dts_article_subject t1, dts_article t2 where t1.subject_id = ?1 and t1.article_id = t2.article_id ",nativeQuery = true)
    List<DtsArticle> findSubjectArticleListBySubjectId(String subjectId);

    @Modifying
    @Transactional
    void deleteByArticleIdAndAuthorId(String articleId, String authorId);

    @Query(value="select * from dts_article t1 , uts_author t2 where t1.state = ?1 and t1.author_id = t2.author_id" ,nativeQuery = true)
    Page<DtsArticleDto> findArticleListState(Integer state, Pageable page);

    @Query(value="?1",nativeQuery = true)
    Page<DtsArticleDto> findGzArticleList(String authorId, Pageable pageable);

    @Query(value="?1",nativeQuery = true)
    List<DtsArticleDto> findArticleList1000();

    @Query(value="?1",nativeQuery = true)
    DtsArticleSubjectDto findSubjectById(String subjectId);

    @Query(value="?1",nativeQuery = true)
    Page<DtsArticleDto> findArticleList(Pageable pageable);

    @Query(value="?1",nativeQuery = true)
    Page<DtsArticleDto> findArticleListSmall(Pageable pageable);

    @Query(value="?1",nativeQuery = true)
    Page<DtsArticleDto> search(String title, Pageable pageable);

    @Query(value = "select * from dts_article t1,dts_author t2 where t1.author_id = t2.author_id and t2.username = ?1",nativeQuery = true)
    Page<DtsArticleDto> findArticleListByUsername(String username, Pageable pageable);

    @Query(value="?1",nativeQuery = true)
    DtsArticleDto findArticle(String id);

    @Query(value="select * from dts_article t1, uts_author t2 where and t1.authorId = ?1 and t1.author_id = t2.author_id",nativeQuery = true)
    DtsArticleDto findArticleAllInfoByAuthorId(String id);

}
