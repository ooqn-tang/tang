package cn.ttcxy.dao.dsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.model.QDtsArticle;
import cn.ttcxy.entity.model.QDtsArticleSubject;
import cn.ttcxy.entity.model.QDtsArticleSubjectRelevance;
import cn.ttcxy.entity.model.QUtsAuthor;
import cn.ttcxy.entity.model.QUtsFans;

/**
 * 文章
 */
@Component
public class DtsArticleDsl {

	private final QUtsAuthor qAuthor = QUtsAuthor.utsAuthor;
	private final QDtsArticle qArticle = QDtsArticle.dtsArticle;
	private final QDtsArticleSubject qDtsArticleSubject = QDtsArticleSubject.dtsArticleSubject;
	private final QDtsArticleSubjectRelevance qSubjectRelevance = QDtsArticleSubjectRelevance.dtsArticleSubjectRelevance;

	@Autowired
	private JPAQueryFactory query;

	public Page<DtsArticleDto> selectArticleList(Pageable pageable) {
		JPAQuery<?> jpaQuery = query
				.from(qAuthor, qArticle)
				.where(qAuthor.authorId.eq(qArticle.authorId), qArticle.state.eq(1));

		Long count = jpaQuery.select(qArticle.articleId.count()).fetchOne();

		List<DtsArticleDto> articleList = jpaQuery
				.select(Projections.bean(DtsArticleDto.class, qArticle.articleId,
						qArticle.title, qArticle.createDate,
						qArticle.updateDate, qAuthor.username,
						qAuthor.nickname, qArticle.synopsis))
				.orderBy(qArticle.createDate.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize()).fetch();

		return new PageImpl<>(articleList, pageable, count);

	}

	public Page<DtsArticleDto> selectGzArticleList(String authorId, Pageable pageable) {

		QUtsFans qFans = QUtsFans.utsFans;

		JPAQuery<?> jpaQuery = query
				.from(qFans)
				.leftJoin(qArticle)
				.on(qFans.beAuthorId.eq(qArticle.authorId))
				.leftJoin(qAuthor)
				.on(qFans.beAuthorId.eq(qAuthor.authorId))
				.where(qFans.authorId.eq(authorId), qArticle.state.eq(1));

		Long totle = jpaQuery.select(qArticle.articleId.count()).fetchOne();

		List<DtsArticleDto> fetch = jpaQuery
				.select(Projections.bean(
						DtsArticleDto.class,
						qArticle.articleId,
						qArticle.title,
						qArticle.createDate,
						qArticle.updateDate,
						qAuthor.username,
						qAuthor.nickname,
						qArticle.synopsis))
				.orderBy(qArticle.createDate.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();
		return new PageImpl<>(fetch, pageable, totle);
	}

	public Page<DtsArticleDto> selectArticleListSmall(Pageable pageable) {

		JPAQuery<?> jpaQuery = query
				.from(qArticle)
				.where(qArticle.state.eq(1));

		Long count = jpaQuery.select(qArticle.articleId.count()).fetchOne();

		List<DtsArticleDto> articleList = jpaQuery
				.select(Projections.bean(
						DtsArticleDto.class,
						qArticle.articleId,
						qArticle.title,
						qArticle.synopsis,
						qArticle.createDate))
				.orderBy(qArticle.createDate.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();
		return new PageImpl<>(articleList, pageable, count);
	}

	public Page<DtsArticleDto> search(String title, Pageable pageable) {
		JPAQuery<?> jpaQuery = query
				.from(qAuthor, qArticle)
				.where(
						qAuthor.authorId.eq(qArticle.authorId),
						qArticle.state.eq(1),
						qArticle.title.like("%" + title + "%"));

		Long count = jpaQuery.select(qArticle.articleId.count()).fetchOne();

		List<DtsArticleDto> articleList = jpaQuery
				.select(Projections.bean(
						DtsArticleDto.class,
						qArticle.articleId,
						qArticle.title,
						qArticle.createDate,
						qArticle.updateDate,
						qAuthor.username,
						qAuthor.nickname,
						qArticle.synopsis))
				.orderBy(qArticle.createDate.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();
		return new PageImpl<>(articleList, pageable, count);
	}

	public DtsArticleDto selectArticleById(String id) {
		return query
				.select(Projections.bean(
						DtsArticleDto.class,
						qArticle.articleId,
						qArticle.title,
						qArticle.createDate,
						qArticle.updateDate,
						qAuthor.username,
						qAuthor.nickname,
						qArticle.text))
				.from(qAuthor, qArticle)
				.where(qArticle.articleId.eq(id), qAuthor.authorId.eq(qArticle.authorId))
				.orderBy(qArticle.createDate.desc())
				.fetchOne();
	}

	public DtsArticleDto selectArticleAllById(String articleId) {
		return query
				.select(Projections.bean(
						DtsArticleDto.class,
						qArticle.articleId,
						qAuthor.username,
						qAuthor.nickname,
						qArticle.title,
						qArticle.createDate,
						qArticle.updateDate,
						qArticle.synopsis,
						qArticle.text,
						qArticle.markdown))
				.from(qAuthor, qArticle)
				.where(qArticle.articleId.eq(articleId), qAuthor.authorId.eq(qArticle.authorId))
				.orderBy(qArticle.createDate.desc())
				.fetchOne();
	}

	public Page<DtsArticleDto> selectArticleListByUsername(String username, Pageable pageable) {
		JPAQuery<?> jpaQuery = query
				.from(qAuthor)
				.innerJoin(qArticle)
				.on(qAuthor.authorId.eq(qArticle.authorId), qAuthor.username.eq(username))
				.leftJoin(qSubjectRelevance)
				.on(qSubjectRelevance.articleId.eq(qArticle.articleId))
				.leftJoin(qDtsArticleSubject)
				.on(qDtsArticleSubject.subjectId.eq(qSubjectRelevance.subjectId))
				.where(qArticle.state.eq(1));

		Long count = jpaQuery.select(qArticle.articleId.count()).fetchOne();

		List<DtsArticleDto> fetch = jpaQuery
				.select(Projections.bean(
						DtsArticleDto.class,
						qArticle.articleId,
						qAuthor.username,
						qAuthor.nickname,
						qArticle.title,
						qArticle.createDate,
						qArticle.updateDate,
						qArticle.synopsis,
						qDtsArticleSubject.subjectName))
				.orderBy(qArticle.createDate.desc())
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();

		return new PageImpl<>(fetch, pageable, count);
	}

	public List<DtsArticleDto> selectArticleList1000() {
		return query
				.select(Projections.bean(
						DtsArticleDto.class,
						qArticle.articleId,
						qArticle.title))
				.from(qArticle)
				.limit(1000)
				.fetch();
	}

}
