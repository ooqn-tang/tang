package cn.ttcxy.mapper.dsl;

import cn.ttcxy.entity.dto.DtsCommentDto;
import cn.ttcxy.entity.dto.DtsDataCount;
import cn.ttcxy.entity.model.QDtsArticle;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
