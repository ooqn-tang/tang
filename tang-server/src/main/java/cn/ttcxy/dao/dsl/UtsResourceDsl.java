package cn.ttcxy.dao.dsl;

import cn.ttcxy.entity.dto.UtsRoleResourceDto;
import cn.ttcxy.entity.model.QUtsResource;
import cn.ttcxy.entity.model.QUtsResourceRole;
import cn.ttcxy.entity.model.QUtsRole;
import cn.ttcxy.entity.model.UtsResource;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 资源
 */
@Component
public class UtsResourceDsl {

	@Autowired
	private JPAQueryFactory query;

	private final QUtsRole qUtsRole = QUtsRole.utsRole;
	private final QUtsResource qUtsResource = QUtsResource.utsResource;
	private final QUtsResourceRole qUtsResourceRole = QUtsResourceRole.utsResourceRole;

	List<UtsRoleResourceDto> selectAll() {
		return query
				.select(Projections.bean(UtsRoleResourceDto.class, qUtsResource.path,
						qUtsResource.name))
				.from(qUtsResource, qUtsResourceRole, qUtsRole)
				.where(qUtsResource.resourceId.eq(qUtsResourceRole.resourceId),
						qUtsRole.roleId.eq(qUtsResourceRole.roleId))
				.fetch();
	}

	public List<UtsResource> loadResourceUrlByRoleValue(String roleValue) {
		return query
				.select(Projections.bean(UtsResource.class, qUtsResource.path, qUtsResource.type))
				.from(qUtsResource, qUtsResourceRole, qUtsRole)
				.where(qUtsResource.resourceId.eq(qUtsResourceRole.resourceId),
						qUtsRole.roleId.eq(qUtsResourceRole.roleId),
						qUtsRole.roleValue.eq(roleValue))
				.fetch();
	}

	public List<String> selectByRoleId(String roleId) {
		return query.select(qUtsResource.resourceId).from(qUtsResource, qUtsResourceRole)
				.where(qUtsResource.resourceId.eq(qUtsResourceRole.resourceId),
						qUtsResourceRole.roleId.eq(roleId))
				.fetch();
	}
}
