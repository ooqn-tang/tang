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

    public Page<DtsArticleSubjectDto> selectSubjectList(Pageable pageable) {
        JPAQuery<?> jpaQuery = query.from(qArticleSubject, qAuthor).where(qAuthor.authorId.eq(qArticleSubject.authorId));

        Long fetchOne = jpaQuery.select(qArticleSubject.subjectId.count()).fetchOne();

        List<DtsArticleSubjectDto> articleSubjectList = jpaQuery.select(Projections.bean(
                DtsArticleSubjectDto.class,
                qArticleSubject.subjectId,
                qArticleSubject.subjectName,
                qArticleSubject.synopsis,
                qArticleSubject.createDate,
                qArticleSubject.updateDate
        )).offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();

        return new PageImpl<>(articleSubjectList,pageable,fetchOne);
    }

    public List<DtsArticleSubjectDto> selectSubjectListByUsername(String username) {
        JPAQuery<?> jpaQuery = query.from(
                qArticleSubject
        ).leftJoin(
                qAuthor
        ).on(
                qAuthor.authorId.eq(qArticleSubject.authorId)
        ).where(
                qAuthor.username.eq(username)
        );

        List<DtsArticleSubjectDto> fetch = jpaQuery.select(Projections.bean(
                DtsArticleSubjectDto.class,
                qArticleSubject.subjectId,
                qArticleSubject.subjectName,
                qArticleSubject.synopsis,
                qArticleSubject.createDate,
                qArticleSubject.updateDate,
                qArticleSubject.authorId,
                qAuthor.username,
                qAuthor.nickname
        )).fetch();

        return fetch;
    }

    public Page<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name,Pageable pageable) {
        JPAQuery<?> jpaQuery = query.from(qArticleSubject).leftJoin(qAuthor).on(qAuthor.authorId.eq(qArticleSubject.authorId)).where(qArticleSubject.subjectName.like('%'+name+'%'));
        Long fetchOne = jpaQuery.select(qArticleSubject.subjectId.count()).fetchOne();
        List<DtsArticleSubjectDto> fetch = jpaQuery.select(Projections.bean(DtsArticleSubjectDto.class, Wildcard.all )).offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();
        return new PageImpl<>(fetch,pageable,fetchOne);

    }

}
