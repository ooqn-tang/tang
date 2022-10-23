package cn.ttcxy.mapper.dsl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.querydsl.jpa.impl.JPAQueryFactory;
import cn.ttcxy.entity.model.QUtsAuthor;
import cn.ttcxy.entity.model.UtsAuthor;

/**
 * 用户
 */
@Component
public class UtsAuthorDsl {

    @Autowired
    private JPAQueryFactory query;

    private QUtsAuthor qAuthor = QUtsAuthor.utsAuthor;

    public long updata(UtsAuthor author) {
        return query.update(qAuthor).set(qAuthor.nickname, author.getNickname())
                .set(qAuthor.signature, author.getSignature())
                .set(qAuthor.updateTime, author.getUpdateTime())
                .where(qAuthor.authorId.eq(author.getAuthorId())).execute();
    }

    public void updateStateDelete(String authorId) {
       
    }

}
