package cn.ttcxy.mapper.dsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.QDtsEssay;
import cn.ttcxy.entity.model.QUtsAuthor;

@Component
public class DtsEssayDsl {

    QDtsEssay qDtsEssay = QDtsEssay.dtsEssay;
    QUtsAuthor qUtsAuthor = QUtsAuthor.utsAuthor;


    @Autowired
    private JPAQueryFactory query;

    public List<DtsEssayDto> select() {
        return query.select(Projections.bean(
                DtsEssayDto.class,
                qDtsEssay.text,
                qDtsEssay.essayId,
                qDtsEssay.createTime,
                qDtsEssay.url,
                qUtsAuthor.nickname,
                qUtsAuthor.username
                )).from(
                qDtsEssay, qUtsAuthor
        ).where(
                qDtsEssay.authorId.eq(qUtsAuthor.authorId)
        ).orderBy(
                qDtsEssay.createTime.desc()
        ).fetch();
    }
}
