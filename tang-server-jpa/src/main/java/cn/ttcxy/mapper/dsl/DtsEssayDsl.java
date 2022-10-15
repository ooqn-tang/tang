package cn.ttcxy.mapper.dsl;

import cn.ttcxy.entity.dto.DtsCommentDto;
import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.QDtsEssay;
import cn.ttcxy.entity.model.QUtsAuthor;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DtsEssayDsl {

    QDtsEssay qDtsEssay = QDtsEssay.dtsEssay;
    QUtsAuthor qUtsAuthor = QUtsAuthor.utsAuthor;


    @Autowired
    private JPAQueryFactory query;

    public List<DtsEssayDto> select() {
        return query.select(Projections.bean(
                DtsEssayDto.class,
                Wildcard.all
        )).from(
                qDtsEssay, qUtsAuthor
        ).where(
                qDtsEssay.authorId.eq(qUtsAuthor.authorId)
        ).orderBy(
                qDtsEssay.createTime.desc()
        ).fetch();
    }
}
