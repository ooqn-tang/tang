package cn.ttcxy.mapper.dsl;

import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.model.QDtsArticle;
import cn.ttcxy.entity.model.QDtsArticleContent;
import cn.ttcxy.entity.model.QDtsArticleSubject;
import cn.ttcxy.entity.model.QUtsAuthor;

import java.util.List;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import org.springframework.beans.factory.annotation.Autowired;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;

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

    public List<DtsArticleDto> selectArticleList(String classId) {
        return query.select(Projections.bean(
                DtsArticleDto.class,
                qArticle.articleId,
                qArticle.title,
                qArticle.createDate,
                qArticle.updateDate,
                qAuthor.username,
                qAuthor.nickname
        )).from(
                qAuthor, qArticle
        ).where(
                qAuthor.authorId.eq(qArticle.authorId),
                qArticle.state.eq(1)
        ).orderBy(qArticle.createDate.desc()).fetch();
    }

    public List<DtsArticleDto> selectGzArticleList(String authorId) {
        return query.select(Projections.bean(
                DtsArticleDto.class, Wildcard.all
        )).from(
                qArticle
        ).where(
                qArticle.state.eq(1)
        ).orderBy(
                qArticle.createDate.desc()
        ).fetch();
    }

    public List<DtsArticleDto> selectArticleListSmall() {
        return query.select(Projections.bean(
                DtsArticleDto.class, Wildcard.all
        )).from(
                qArticle
        ).where(
                qArticle.state.eq(1)
        ).orderBy(
                qArticle.createDate.desc()
        ).fetch();
    }

    public List<DtsArticleDto> search(String title) {
        return query.select(Projections.bean(
                DtsArticleDto.class, Wildcard.all
        )).from(
                qAuthor, qArticle
        ).where(
                qAuthor.authorId.eq(qArticle.authorId),
                qArticle.state.eq(1),
                qArticle.title.like("%" + title + "%")
        ).orderBy(
                qArticle.createDate.desc()
        ).fetch();
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
                qArticleContent.text
        )).from(
                qAuthor, qArticle
        ).where(
                qArticle.articleId.eq(id),
                qAuthor.authorId.eq(qArticle.authorId)
        ).leftJoin(
                qArticleContent
        ).on(
                qArticleContent.articleId.eq(qArticle.articleId)
        ).orderBy(
                qArticle.createDate.desc()
        ).fetchOne();
    }

    public DtsArticleDto selectArticleAllById(String id) {
        return query.select(Projections.bean(
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
                qArticle.subjectId
        )).from(
                qAuthor, qArticle
        ).where(
                qArticle.articleId.eq(id),
                qAuthor.authorId.eq(qArticle.authorId)
        ).leftJoin(
                qArticleContent
        ).on(
                qArticleContent.articleId.eq(qArticle.articleId)
        ).orderBy(
                qArticle.createDate.desc()
        ).fetchOne();
    }

    public List<DtsArticleDto> selectArticleListByUsername(String username) {
        return query.select(Projections.bean(
                DtsArticleDto.class,
                qArticle.articleId,
                qAuthor.username,
                qAuthor.nickname,
                qArticle.title,
                qArticle.createDate,
                qArticle.updateDate,
                qArticle.synopsis,
                qArticle.subjectId
        )).from(
                qAuthor
        ).innerJoin(
                qArticle
        ).on(
                qAuthor.authorId.eq(qArticle.authorId),
                qAuthor.username.eq(username)
        ).leftJoin(
                qDtsArticleSubject
        ).on(
                qDtsArticleSubject.subjectId.eq(qArticle.subjectId)
        ).where(
                qArticle.state.eq(1)
        ).orderBy(
                qArticle.createDate.desc()
        ).fetch();
    }

    public List<DtsArticleDto> selectArticleList1000() {
        return query.select(Projections.bean(
                DtsArticleDto.class,
                qArticle.articleId,
                qArticle.title
        )).from(qArticle).limit(1000).fetch();
    }

}
