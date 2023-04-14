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

    @Query(value="?1",nativeQuery = true)
    List<DtsArticle> findAllBySubjectId(String subjectId);

    @Modifying
    @Transactional
    void deleteByArticleIdAndAuthorId(String articleId, String authorId);

    @Query(value="?1",nativeQuery = true)
    Page<DtsArticleDto> selectArticleListState(Pageable page, Integer state);

    @Query(value="?1",nativeQuery = true)
    Page<DtsArticleDto> selectGzArticleList(String authorId, Pageable pageable);

    @Query(value="?1",nativeQuery = true)
    List<DtsArticleDto> selectArticleList1000();

    @Query(value="?1",nativeQuery = true)
    DtsArticleSubjectDto findSubjectById(String subjectId);

    @Query(value="?1",nativeQuery = true)
    Page<DtsArticleDto> selectArticleList(Pageable pageable);

    @Query(value="?1",nativeQuery = true)
    Page<DtsArticleDto> selectArticleListSmall(Pageable pageable);

    @Query(value="?1",nativeQuery = true)
    Page<DtsArticleDto> search(String title, Pageable pageable);

    @Query(value = "select * from dts_article t1,dts_author t2 where t1.author_id = t2.author_id and t2.username = ?1",nativeQuery = true)
    Page<DtsArticleDto> selectArticleListByUsername(String username, Pageable pageable);

    @Query(value="?1",nativeQuery = true)
    DtsArticleDto selectArticle(String id);

    @Query(value="?1",nativeQuery = true)
    DtsArticleDto selectArticleAll(String id);

}
