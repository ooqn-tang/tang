package cn.ttcxy.dao.dsl;

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

import cn.ttcxy.entity.dto.UtsFansDto;
import cn.ttcxy.entity.model.QUtsAuthor;
import cn.ttcxy.entity.model.QUtsFans;

/**
 * 粉丝
 */
@Component
public class UtsFansDsl {

    @Autowired
    private JPAQueryFactory query;

    private QUtsFans qFans = QUtsFans.utsFans;
    private QUtsAuthor qAuthor = QUtsAuthor.utsAuthor;
    private QUtsAuthor qAuthor1 = QUtsAuthor.utsAuthor;

    public Page<UtsFansDto> selectFansList(String userId, Pageable pageable) {
        JPAQuery<?> jpaQuery = query.from(qFans, qAuthor, qAuthor1)
                .where(qAuthor.authorId.eq(qFans.authorId), qAuthor1.authorId.eq(qFans.authorId),
                        qFans.authorId.eq(userId));

        Long fetchOne = jpaQuery.select(qFans.fansId.count()).fetchOne();

        List<UtsFansDto> fansList = jpaQuery
                .select(Projections.bean(UtsFansDto.class, qFans.fansId, qFans.authorId, qFans.beAuthorId,
                        qAuthor.nickname, qAuthor.username))
                .orderBy(qFans.createDate.asc()).offset(pageable.getOffset())
                .limit(pageable.getPageSize()).fetch();
        return new PageImpl<>(fansList, pageable, fetchOne);
    }

    public Long isFans(String authorId, String beAuthorId) {
        return query.select(Wildcard.count)
                .from(qFans)
                .where(qFans.authorId.eq(authorId), qFans.beAuthorId.eq(beAuthorId))
                .fetchOne();
    }
}
