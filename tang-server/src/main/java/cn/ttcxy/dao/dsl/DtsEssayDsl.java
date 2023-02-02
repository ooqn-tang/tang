package cn.ttcxy.dao.dsl;

import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.QDtsEssay;
import cn.ttcxy.entity.model.QUtsAuthor;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class DtsEssayDsl {

	private final QDtsEssay qDtsEssay = QDtsEssay.dtsEssay;
	private final QUtsAuthor qUtsAuthor = QUtsAuthor.utsAuthor;

	@Autowired
	private JPAQueryFactory query;

	public Page<DtsEssayDto> select(Pageable pageable) {
		JPAQuery<?> jpaQuery = query
				.from(qDtsEssay, qUtsAuthor)
				.where(qDtsEssay.authorId.eq(qUtsAuthor.authorId));

		Long fetchOne = jpaQuery
				.select(qDtsEssay.essayId.count())
				.fetchOne();

		List<DtsEssayDto> fetch = jpaQuery
				.select(Projections.bean(
						DtsEssayDto.class,
						qDtsEssay.text,
						qDtsEssay.essayId,
						qDtsEssay.createTime,
						qDtsEssay.url,
						qUtsAuthor.nickname,
						qUtsAuthor.username))
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.orderBy(qDtsEssay.createTime.desc())
				.fetch();

		return new PageImpl<>(fetch, pageable, fetchOne);
	}
}
