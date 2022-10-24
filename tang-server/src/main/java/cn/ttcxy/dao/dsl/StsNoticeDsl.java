package cn.ttcxy.dao.dsl;

import cn.ttcxy.entity.model.QStsNotice;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 推荐
 */
@Component
public class StsNoticeDsl {

  @Autowired
  private JPAQueryFactory query;

  private final QStsNotice qNotice = QStsNotice.stsNotice;

  public Integer selectNoticeMaxOrder() {
    Integer fetchOne = query
      .select(qNotice.orderNum.max())
      .from(qNotice)
      .orderBy(qNotice.orderNum.desc())
      .limit(1)
      .fetchOne();

    return Optional.ofNullable(fetchOne).orElse(0);
  }
}
