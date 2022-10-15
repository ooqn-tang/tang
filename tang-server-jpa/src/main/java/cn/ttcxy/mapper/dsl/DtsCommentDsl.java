package cn.ttcxy.mapper.dsl;

import cn.hutool.core.util.ArrayUtil;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.dto.DtsCommentDto;
import cn.ttcxy.entity.model.QDtsComment;
import cn.ttcxy.entity.model.QStsCode;
import cn.ttcxy.entity.model.QUtsAuthor;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 评论
 */
@Component
public class DtsCommentDsl {

    @Autowired
    private JPAQueryFactory query;

    QDtsComment qDtsComment = QDtsComment.dtsComment;
    QUtsAuthor qUtsAuthor = QUtsAuthor.utsAuthor;
    QStsCode qStsCode = QStsCode.stsCode;

    public List<DtsCommentDto> select(String dataId) {
        return null;
    }

    public List<DtsCommentDto> selectLower(String commentId) {
        return query.select(Projections.bean(
                DtsCommentDto.class,
                Wildcard.all
        )).from(
                qDtsComment, qUtsAuthor
        ).where(
                qDtsComment.parentCommentId.eq(commentId),
                qUtsAuthor.authorId.eq(qDtsComment.authorId)
        ).fetch();
    }

    public List<DtsCommentDto> selectAll(Integer state) {
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(qDtsComment.authorId.eq(qUtsAuthor.authorId));
        predicateList.add(qDtsComment.state.eq(qStsCode.codeId));
        if (state != null){
            predicateList.add(qDtsComment.state.eq(state));
        }
        Predicate[] predicate = ArrayUtil.toArray(predicateList,Predicate.class);
        return query.select(Projections.bean(
                DtsCommentDto.class,
                Wildcard.all
        )).from(
                qDtsComment, qUtsAuthor,qStsCode
        ).where(predicate).fetch();
    }

}
