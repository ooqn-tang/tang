package cn.ttcxy.mapper.dsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.entity.model.QDtsArticle;

/**
 * 同时获取视频，博客
 */
@Component
public class DtsDataDsl {

    QDtsArticle qDtsArticle = QDtsArticle.dtsArticle;

    @Autowired
    private JPAQueryFactory query;

    public Integer selectDataType(String dataId) {
        return 1;
    }

    public String selectDataAuthorId(String dataId) {
        return query.select(Projections.bean(
                String.class,
                Wildcard.all
        )).from(
                qDtsArticle
        ).where(
                qDtsArticle.articleId.eq(dataId)
        ).fetchOne();
    }

}
