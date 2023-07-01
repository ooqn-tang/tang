package com.ooqn.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.DtsArticle;

public interface DtsArticleRepository extends CrudRepository<DtsArticle, String> {

    @Modifying
    void deleteByArticleIdAndAuthorId(String articleId, String authorId);

    void deleteByArticleId(String articleId);

    @Query("""
    select da From DtsArticle da where
    da.authorId in (select ua.authorId from UtsAuthor ua where ua.username = ?1)
    order by da.createTime desc
    """)
    Page<DtsArticle> findArticleListByUsername(String username, Pageable pageable);

    @Query("""
    select da from DtsArticle da where
    da.articleId in (select dsr.dataId from DtsSubjectRelevance dsr where dsr.subjectId = ?1)
    """)
    List<DtsArticle> findSubjectById(String subjectId);

    @Query("select da from DtsArticle da")
    Page<DtsArticle> findArticleList(Pageable pageable);

    @Query("select da from DtsArticle da where da.categoryId = ?1")
    Page<DtsArticle> findArticleListByCategoryId(String categoryId, Pageable pageable);

    @Query("""
    From DtsArticle da where
    da.articleId in (select dsr.dataId from DtsSubjectRelevance dsr where dsr.dataId = ?1)
    """)
    List<DtsArticle> findSubjectArticleListByArticleId(String articleId);

    @Query("from DtsArticle order by rand() limit 10")
    List<DtsArticle> randomArticle();

    @Query("""
    select da From DtsArticle da where
    da.authorId in (select df.beAuthorId from UtsFans df where df.authorId = ?1)
    order by da.createTime desc
    """)
    Page<DtsArticle> findFansArticleList(String authorId, Pageable pageable);

    @Query("""
    select da From DtsArticle da where
    da.articleId in (
        select dsr.dataId from DtsSubjectRelevance dsr
        where dsr.subjectId = (select ds.subjectId from DtsSubjectRelevance ds where ds.dataId = ?1)
    )
    """)
    List<DtsArticle> findSubjectArticleTitleListByArticleId(String articleId);

    @Query("select da From DtsArticle da where da.state = ?1")
    Page<DtsArticle> findArticleListState(Integer state, Pageable page);

    @Query("select da From DtsArticle da")
    Page<DtsArticle> findArticleListSmall(Pageable pageable);

    @Query("select da From DtsArticle da where da.title like %?1%")
    Page<DtsArticle> search(String title, Pageable pageable);

}
