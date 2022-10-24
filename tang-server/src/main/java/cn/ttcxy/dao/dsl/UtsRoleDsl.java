package cn.ttcxy.dao.dsl;

import cn.ttcxy.entity.dto.UtsRoleDto;
import cn.ttcxy.entity.model.QUtsAuthor;
import cn.ttcxy.entity.model.QUtsAuthorRole;
import cn.ttcxy.entity.model.QUtsRole;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 角色
 */
@Component
public class UtsRoleDsl {

  private final QUtsAuthor qUtsAuthor = QUtsAuthor.utsAuthor;
  private final QUtsAuthorRole qUtsAuthorRole = QUtsAuthorRole.utsAuthorRole;
  private final QUtsRole qUtsRole = QUtsRole.utsRole;

  @Autowired
  private JPAQueryFactory query;

  public List<UtsRoleDto> selectRoleListByAuthorId(String authorId) {
    return query
      .select(
        Projections.bean(
          UtsRoleDto.class,
          qUtsRole.createTime,
          qUtsRole.refreshTime,
          qUtsRole.roleId,
          qUtsRole.roleName,
          qUtsRole.roleValue,
          qUtsRole.updateTime
        )
      )
      .from(qUtsRole, qUtsAuthorRole)
      .where(
        qUtsRole.roleId.eq(qUtsAuthorRole.roleId),
        qUtsAuthorRole.authorId.eq(authorId)
      )
      .fetch();
  }

  public List<String> selectRoleIdList(String authorId) {
    return query
      .select(qUtsAuthorRole.roleId)
      .from(qUtsAuthor, qUtsAuthorRole)
      .where(
        qUtsAuthor.authorId.eq(qUtsAuthorRole.authorId),
        qUtsAuthorRole.authorId.eq(authorId)
      )
      .fetch();
  }
}
