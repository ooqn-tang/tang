package cn.ttcxy.dao.dsl;

import cn.ttcxy.entity.model.DtsCollect;
import cn.ttcxy.entity.model.QDtsCollect;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * 收藏
 */
@Component
public class DtsCollectDsl {

  private final QDtsCollect qCollect = QDtsCollect.dtsCollect;

  @Autowired
  private JPAQueryFactory query;

  public Page<DtsCollect> selectCollect(String authorId, Pageable pageable) {
    JPAQuery<?> fromQuery = query
      .from(qCollect)
      .where(qCollect.authorId.eq(authorId));

    Long fetchOne = fromQuery.select(qCollect.collectId.count()).fetchOne();

    List<DtsCollect> fetch = fromQuery
      .select(qCollect)
      .offset(pageable.getOffset())
      .limit(pageable.getPageSize())
      .orderBy(qCollect.createDate.desc())
      .fetch();

    return new PageImpl<>(fetch, pageable, fetchOne);
  }
}
