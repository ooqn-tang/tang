package cn.ttcxy.mapper.dsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.model.QDtsArticle;
import cn.ttcxy.entity.model.QDtsArticleContent;
import cn.ttcxy.entity.model.QDtsArticleSubject;
import cn.ttcxy.entity.model.QUtsAuthor;

/**
 * 文章
 */
@Component
public class DtsArticleDsl {

    private final QUtsAuthor qAuthor = QUtsAuthor.utsAuthor;
    private final QDtsArticle qArticle = QDtsArticle.dtsArticle;
    private final QDtsArticleContent qArticleContent = QDtsArticleContent.dtsArticleContent;
    private final QDtsArticleSubject qDtsArticleSubject = QDtsArticleSubject.dtsArticleSubject;

    @Autowired
    private JPAQueryFactory query;

    public Page<DtsArticleDto> selectArticleList(String classId, Pageable pageable) {
        JPAQuery<?> jpaQuery = query
                .from(
                        qAuthor, qArticle)
                .where(
                        qAuthor.authorId.eq(qArticle.authorId),
                        qArticle.state.eq(1));



        Long count = jpaQuery.select(qArticle.articleId.count()).fetchOne();

        List<DtsArticleDto> articleList = jpaQuery.select(Projections.bean(
                DtsArticleDto.class,
                qArticle.articleId,
                qArticle.title,
                qArticle.createDate,
                qArticle.updateDate,
                qAuthor.username,
                qAuthor.nickname,
                qArticle.synopsis
                ))
                .orderBy(qArticle.createDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize()).fetch();

        return new PageImpl<>(articleList, pageable, count);       
                
    }

    public Page<DtsArticleDto> selectGzArticleList(String authorId, Pageable pageable) {

        JPAQuery<?> jpaQuery = query
                .from(qArticle).where(qArticle.state.eq(1)).orderBy(qArticle.createDate.desc());

        Long totle = jpaQuery
                .select(Projections.bean(Long.class, qArticle.articleId.count())).fetchOne();

        List<DtsArticleDto> fetch = jpaQuery
                .select(Projections.bean(DtsArticleDto.class, Wildcard.all))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize()).fetch();

        return new PageImpl<>(fetch, pageable, totle);

    }

    public List<DtsArticleDto> selectArticleListSmall() {
        return query.select(Projections.bean(
                DtsArticleDto.class, Wildcard.all)).from(
                        qArticle)
                .where(
                        qArticle.state.eq(1))
                .orderBy(
                        qArticle.createDate.desc())
                .fetch();
    }

    public List<DtsArticleDto> search(String title) {
        return query.select(Projections.bean(
                DtsArticleDto.class, Wildcard.all)).from(
                        qAuthor, qArticle)
                .where(
                        qAuthor.authorId.eq(qArticle.authorId),
                        qArticle.state.eq(1),
                        qArticle.title.like("%" + title + "%"))
                .orderBy(
                        qArticle.createDate.desc())
                .fetch();
    }

    public DtsArticleDto selectArticleById(String id) {
        return query.select(Projections.bean(
                DtsArticleDto.class,
                qArticle.articleId,
                qArticle.title,
                qArticle.createDate,
                qArticle.updateDate,
                qAuthor.username,
                qAuthor.nickname,
                qArticleContent.text)).from(
                        qAuthor, qArticle)
                .where(
                        qArticle.articleId.eq(id),
                        qAuthor.authorId.eq(qArticle.authorId))
                .leftJoin(
                        qArticleContent)
                .on(
                        qArticleContent.articleId.eq(qArticle.articleId))
                .orderBy(
                        qArticle.createDate.desc())
                .fetchOne();
    }

    public DtsArticleDto selectArticleAllById(String id) {
        return query.select(
                Projections.bean(
                        DtsArticleDto.class,
                        qArticle.articleId,
                        qAuthor.username,
                        qAuthor.nickname,
                        qArticle.title,
                        qArticle.createDate,
                        qArticle.updateDate,
                        qArticle.synopsis,
                        qArticleContent.text,
                        qArticleContent.markdown,
                        qArticle.subjectId))
                .from(
                        qAuthor, qArticle)
                .where(
                        qArticle.articleId.eq(id),
                        qAuthor.authorId.eq(qArticle.authorId))
                .leftJoin(
                        qArticleContent)
                .on(
                        qArticleContent.articleId.eq(qArticle.articleId))
                .orderBy(
                        qArticle.createDate.desc())
                .fetchOne();
    }

    public Page<DtsArticleDto> selectArticleListByUsername(String username, Pageable pageable) {
         JPAQuery<?> jpaQuery = query
                .from(qAuthor)
                .innerJoin(qArticle)
                .on(qAuthor.authorId.eq(qArticle.authorId), qAuthor.username.eq(username))
                .leftJoin(qDtsArticleSubject)
                .on(qDtsArticleSubject.subjectId.eq(qArticle.subjectId))
                .where(qArticle.state.eq(1))
                .orderBy(qArticle.createDate.desc());

        Long count = jpaQuery.select(qArticle.articleId.count()).fetchOne();

        List<DtsArticleDto> fetch = jpaQuery.select(Projections.bean(
                DtsArticleDto.class,
                qArticle.articleId,
                qAuthor.username,
                qAuthor.nickname,
                qArticle.title,
                qArticle.createDate,
                qArticle.updateDate,
                qArticle.synopsis,
                qArticle.subjectId,
                qDtsArticleSubject.subjectName
                )).offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();
        return new PageImpl<>(fetch, pageable, count);
    }

    public List<DtsArticleDto> selectArticleList1000() {
        return query.select(Projections.bean(
                DtsArticleDto.class,
                qArticle.articleId,
                qArticle.title)).from(qArticle).limit(1000).fetch();
    }

}
