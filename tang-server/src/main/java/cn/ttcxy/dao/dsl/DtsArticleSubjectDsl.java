package cn.ttcxy.dao.dsl;

import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.QDtsArticle;
import cn.ttcxy.entity.model.QDtsArticleSubject;
import cn.ttcxy.entity.model.QDtsArticleSubjectRelevance;
import cn.ttcxy.entity.model.QUtsAuthor;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * 文章专辑
 */
@Component
public class DtsArticleSubjectDsl {

  private final QDtsArticleSubject qArticleSubject =
    QDtsArticleSubject.dtsArticleSubject;
  private final QUtsAuthor qAuthor = QUtsAuthor.utsAuthor;
  private final QDtsArticleSubjectRelevance qSubjectRelevance =
    QDtsArticleSubjectRelevance.dtsArticleSubjectRelevance;
  private final QDtsArticle qArticle = QDtsArticle.dtsArticle;

  @Autowired
  private JPAQueryFactory query;

  public DtsArticleSubjectDto findSubjectById(String subjectId) {
    return query
      .select(
        Projections.bean(
          DtsArticleSubjectDto.class,
          qArticleSubject.subjectId,
          qArticleSubject.subjectName,
          qArticleSubject.synopsis,
          qArticleSubject.createDate,
          qAuthor.nickname,
          qAuthor.username
        )
      )
      .from(qArticleSubject, qAuthor)
      .where(
        qAuthor.authorId.eq(qArticleSubject.authorId),
        qArticleSubject.subjectId.eq(subjectId)
      )
      .fetchOne();
  }

  public Page<DtsArticleSubjectDto> findSubjectList(Pageable pageable) {
    JPAQuery<?> jpaQuery = query
      .from(qArticleSubject, qAuthor)
      .where(qAuthor.authorId.eq(qArticleSubject.authorId));

    Long fetchOne = jpaQuery
      .select(qArticleSubject.subjectId.count())
      .fetchOne();

    List<DtsArticleSubjectDto> articleSubjectList = jpaQuery
      .select(
        Projections.bean(
          DtsArticleSubjectDto.class,
          qArticleSubject.subjectId,
          qArticleSubject.subjectName,
          qArticleSubject.synopsis,
          qArticleSubject.createDate,
          qArticleSubject.updateDate
        )
      )
      .offset(pageable.getOffset())
      .limit(pageable.getPageSize())
      .fetch();

    return new PageImpl<>(articleSubjectList, pageable, fetchOne);
  }

  public List<DtsArticleSubjectDto> findSubjectListByUsername(String username) {
    JPAQuery<?> jpaQuery = query
      .from(qArticleSubject)
      .leftJoin(qAuthor)
      .on(qAuthor.authorId.eq(qArticleSubject.authorId))
      .where(qAuthor.username.eq(username));

    return jpaQuery
      .select(
        Projections.bean(
          DtsArticleSubjectDto.class,
          qArticleSubject.subjectId,
          qArticleSubject.subjectName,
          qArticleSubject.synopsis,
          qArticleSubject.createDate,
          qArticleSubject.updateDate,
          qArticleSubject.authorId,
          qAuthor.username,
          qAuthor.nickname
        )
      )
      .fetch();
  }

  public Page<DtsArticleSubjectDto> findSubjectListBySubjectName(
    String name,
    Pageable pageable
  ) {
    JPAQuery<?> jpaQuery = query
      .from(qArticleSubject)
      .leftJoin(qAuthor)
      .on(qAuthor.authorId.eq(qArticleSubject.authorId))
      .where(qArticleSubject.subjectName.like('%' + name + '%'));

    Long fetchOne = jpaQuery
      .select(qArticleSubject.subjectId.count())
      .fetchOne();

    List<DtsArticleSubjectDto> fetch = jpaQuery
      .select(Projections.bean(DtsArticleSubjectDto.class, Wildcard.all))
      .offset(pageable.getOffset())
      .limit(pageable.getPageSize())
      .fetch();

    return new PageImpl<>(fetch, pageable, fetchOne);
  }

  public String findSubjectIdByArticleId(String articleId) {
    return query
      .select(qSubjectRelevance.subjectId)
      .from(qSubjectRelevance)
      .where(qSubjectRelevance.articleId.eq(articleId))
      .fetchOne();
  }

  public List<DtsArticle> findAllBySubjectId(String subjectId) {
    return query
      .select(qArticle)
      .from(qArticle, qSubjectRelevance)
      .where(
        qArticle.articleId.eq(qSubjectRelevance.articleId),
        qSubjectRelevance.subjectId.eq(subjectId)
      )
      .fetch();
  }

  public List<DtsArticle> findSubjectArticleTitleListBySubjectId(
    String subjectId
  ) {
    return query
      .select(
        Projections.bean(DtsArticle.class, qArticle.articleId, qArticle.title)
      )
      .from(qArticle, qSubjectRelevance)
      .where(
        qArticle.articleId.eq(qSubjectRelevance.articleId),
        qSubjectRelevance.subjectId.eq(subjectId)
      )
      .fetch();
  }

  public void deleteBySubjectIdAndAuthorId(String subjectId, String authorId) {
    query
      .delete(qArticleSubject)
      .where(
        qArticleSubject.authorId.eq(authorId),
        qArticleSubject.subjectId.eq(subjectId)
      )
      .execute();
  }
}
