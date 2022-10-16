package cn.ttcxy.mapper.dsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.QDtsArticleSubject;
import cn.ttcxy.entity.model.QUtsAuthor;

/**
 * 文章专辑
 */
@Component
public class DtsArticleSubjectDsl {

    private final QDtsArticleSubject qArticleSubject = QDtsArticleSubject.dtsArticleSubject;
    private final QUtsAuthor qAuthor = QUtsAuthor.utsAuthor;

    @Autowired
    private JPAQueryFactory query;

    public DtsArticleSubjectDto selectSubjectById(String subjectId) {
        return query.select(Projections.bean(
                DtsArticleSubjectDto.class,
                qArticleSubject.subjectId,
                qArticleSubject.subjectName
        )).from(
                qArticleSubject, qAuthor
        ).where(
                qAuthor.authorId.eq(qArticleSubject.authorId),
                qArticleSubject.subjectId.eq(subjectId)
        ).fetchOne();
    }

    public List<DtsArticleSubjectDto> selectSubjectList() {
        return query.select(Projections.bean(
                DtsArticleSubjectDto.class,
                qArticleSubject.subjectId,
                qArticleSubject.subjectName,
                qArticleSubject.synopsis,
                qArticleSubject.createDate,
                qArticleSubject.updateDate
        )).from(
                qArticleSubject, qAuthor
        ).where(
                qAuthor.authorId.eq(qArticleSubject.authorId)
        ).fetch();
    }

    public List<DtsArticleSubjectDto> selectSubjectListByUsername(String username) {
        return query.select(Projections.bean(
                DtsArticleSubjectDto.class,
                qArticleSubject.subjectId,
                qArticleSubject.subjectName,
                qArticleSubject.synopsis,
                qArticleSubject.createDate,
                qArticleSubject.updateDate,
                qArticleSubject.authorId,
                qAuthor.username,
                qAuthor.nickname
        )).from(
                qArticleSubject
        ).leftJoin(
                qAuthor
        ).on(
                qAuthor.authorId.eq(qArticleSubject.authorId)
        ).where(
                qAuthor.username.eq(username)
        ).fetch();
    }

    public List<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name) {
        return query.select(Projections.bean(
                DtsArticleSubjectDto.class,
                Wildcard.all
        )).from(
                qArticleSubject
        ).leftJoin(
                qAuthor
        ).on(
                qAuthor.authorId.eq(qArticleSubject.authorId)
        ).where(
                qArticleSubject.subjectName.like('%'+name+'%')
        ).fetch();
    }

}
