package cn.ttcxy.mapper.dsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.entity.model.QStsNotice;

/**
 * 推荐
 */
@Component
public class StsNoticeDsl {

    @Autowired
    private JPAQueryFactory query;

    private final QStsNotice qNotice = QStsNotice.stsNotice;

    public Integer selectNoticeMaxOrder() {
        return query.select(Projections.bean(Integer.class, qNotice.orderNum)).from(qNotice)
                .orderBy(qNotice.orderNum.desc()).limit(1).fetchOne();
    }

}
