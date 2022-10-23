package cn.ttcxy.mapper.dsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.entity.dto.UtsRoleDto;
import cn.ttcxy.entity.model.QUtsAuthor;
import cn.ttcxy.entity.model.QUtsAuthorRole;
import cn.ttcxy.entity.model.QUtsRole;

/**
 * 角色
 */
@Component
public class UtsRoleDsl {

    // 查询工厂实体
    @Autowired
    private JPAQueryFactory query;

    public List<UtsRoleDto> selectRoleListByAuthorId(String authorId) {

        QUtsRole qUtsRole = QUtsRole.utsRole;
        QUtsAuthorRole qUtsAuthorRole = QUtsAuthorRole.utsAuthorRole;

        return query.select(Projections.bean(
                UtsRoleDto.class,
                qUtsRole.createTime,
                qUtsRole.refreshTime,
                qUtsRole.roleId,
                qUtsRole.roleName,
                qUtsRole.roleValue,
                qUtsRole.updateTime)).from(qUtsRole, qUtsAuthorRole).where(
                        qUtsRole.roleId.eq(qUtsAuthorRole.roleId),
                        qUtsAuthorRole.authorId.eq(authorId))
                .fetch();

    }

    public List<String> selectRoleIdList(String authorId) {

        QUtsAuthor qUtsAuthor = QUtsAuthor.utsAuthor;
        QUtsAuthorRole qUtsAuthorRole = QUtsAuthorRole.utsAuthorRole;

        return query.select(qUtsAuthorRole.roleId).from(qUtsAuthor, qUtsAuthorRole).where(
                        qUtsAuthor.authorId.eq(qUtsAuthorRole.authorId),
                        qUtsAuthorRole.authorId.eq(authorId))
                .fetch();

    }

}
