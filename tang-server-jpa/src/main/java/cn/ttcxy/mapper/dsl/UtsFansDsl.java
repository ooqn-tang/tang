package cn.ttcxy.mapper.dsl;

import cn.ttcxy.entity.dto.UtsFansDto;
import cn.ttcxy.entity.model.QUtsAuthor;
import cn.ttcxy.entity.model.QUtsFans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;

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

    public List<UtsFansDto> selectFansList(String userId) {
        return query.select(Projections.bean(
                        UtsFansDto.class,
                        qFans.fansId,
                        qFans.authorId,
                        qFans.beAuthorId,
                        qAuthor.nickname,
                        qAuthor.username
                )).from(qFans, qAuthor, qAuthor1)
                .where(qAuthor.authorId.eq(qFans.authorId),
                        qAuthor1.authorId.eq(qFans.authorId),
                        qFans.authorId.eq(userId))
                .orderBy(qFans.createDate.asc()).fetch();
    }

    public Long isFans(String authorId, String beAuthorId) {
        return query.select(Wildcard.count)
                .from(qFans)
                .where(qFans.authorId.eq(authorId), qFans.beAuthorId.eq(beAuthorId))
                .fetchOne();
    }
}
