package com.ooqn.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ooqn.entity.StateNum;
import com.ooqn.entity.dto.DtsArticleDto;
import com.ooqn.entity.dto.DtsSubjectDto;
import com.ooqn.entity.model.DtsArticle;
import com.ooqn.entity.model.DtsContext;
import com.ooqn.entity.model.DtsSubject;
import com.ooqn.entity.model.DtsSubjectRelevance;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.repository.DtsArticleRepository;
import com.ooqn.repository.DtsCategoryRepository;
import com.ooqn.repository.DtsContextRepository;
import com.ooqn.repository.DtsSubjectRelevanceRepository;
import com.ooqn.repository.DtsSubjectRepository;
import com.ooqn.repository.UtsAuthorRepository;
import com.ooqn.util.CommonUtil;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 文章于文章专辑相关
 */
@Service
public class DtsArticleSubjectService {

	@Autowired
	private UtsAuthorRepository authorRepository;

	@Autowired
	private DtsSubjectRepository subjectRepository;

	@Autowired
	private DtsArticleRepository articleRepository;

	@Autowired
	private DtsSubjectRelevanceRepository subjectRelevanceRepository;

	@Autowired
	private DtsCategoryRepository categoryRepository;

	@Autowired
	private DtsContextRepository contextRepository;

	/**
	 * 查询这个专辑的所有文章
	 */
	public DtsSubjectDto findSubjectArticleListBySubjectId(String subjectId) {
		List<DtsArticle> articleList = articleRepository.findSubjectById(subjectId);
		DtsSubject subject = subjectRepository.findById(subjectId).orElseThrow();
		UtsAuthor author = authorRepository.findUsernameNicknameByAuthorId(subject.getAuthorId()).orElseThrow();
		DtsSubjectDto articleSubjectDto = new DtsSubjectDto(subject);
		articleSubjectDto.setDataArray(articleList);
		articleSubjectDto.setAuthor(author);
		return articleSubjectDto;
	}

	/**
	 * 通过文章id查询专辑
	 * 
	 * @param articleId 文章id
	 * @return List<DtsArticle>
	 */
	public DtsSubjectDto findSubjectArticleTitleListByArticleId(String articleId) {
		DtsSubject orElseThrow = subjectRepository.findByDataId(articleId).orElseThrow();
		DtsSubjectDto subjectDto = new DtsSubjectDto(orElseThrow);
		List<DtsArticle> articleList = articleRepository.findSubjectArticleListByArticleId(articleId);
		subjectDto.setDataArray(articleList);
		return subjectDto;
	}

	/**
	 * 通过文章id查询专辑
	 * 
	 * @param categoryId 分类id
	 * @param pageable   分页
	 * @return Page<DtsArticleDto>
	 */
	public Page<DtsArticleDto> selectArticleList(String categoryId, Pageable pageable) {
		Page<DtsArticle> findArticleList;
		if (StrUtil.equals(categoryId, "0")) {
			findArticleList = articleRepository.findArticleList(pageable);
		} else {
			findArticleList = articleRepository.findArticleListByCategoryId(categoryId, pageable);
		}
		return findArticleList.map(article -> {
			String authorId = article.getAuthorId();
			String articleCategoryId = article.getCategoryId();
			DtsArticleDto articleDto = new DtsArticleDto(article);
			if (articleCategoryId != null) {
				categoryRepository.findById(articleCategoryId).ifPresent(articleDto::setCategory);
			}
			authorRepository.findById(authorId).ifPresent(articleDto::setAuthor);
			return articleDto;
		});
	}

	public Page<DtsArticleDto> selectArticleListSmall(Pageable pageable) {
		Page<DtsArticle> articlePage = articleRepository.findArticleListSmall(pageable);
		return articlePage.map(a -> {
			DtsArticleDto articleDto = new DtsArticleDto(a);
			articleDto.setAuthor(authorRepository.findUsernameNicknameByAuthorId(a.getAuthorId()).orElseThrow());
			return articleDto;
		});
	}

	public Page<DtsArticleDto> search(String title, Pageable pageable) {
		Page<DtsArticle> articlePage = articleRepository.search(title, pageable);
		return articlePage.map(article -> {
			DtsArticleDto articleDto = new DtsArticleDto(article);
			articleDto.setAuthor(authorRepository.findUsernameNicknameByAuthorId(article.getAuthorId()).orElseThrow());
			return articleDto;
		});
	}

	public Page<DtsArticleDto> selectArticleByAuthorName(String username, Pageable pageable) {
		Page<DtsArticle> articleList = articleRepository.findArticleListByUsername(username, pageable);
		return articleList.map(article -> {
			DtsArticleDto articleDto = new DtsArticleDto(article);
			articleDto.setAuthor(authorRepository.findUsernameNicknameByAuthorId(article.getAuthorId()).orElseThrow());
			articleDto.setSubject(subjectRepository.findByDataId(article.getArticleId()).orElse(null));
			String categoryId = article.getCategoryId();
			if (categoryId != null) {
				categoryRepository.findById(categoryId).ifPresent(articleDto::setCategory);
			}
			return articleDto;
		});
	}

	public DtsArticle insertArticle(String authorId, String subjectId) {
		DateTime date = DateUtil.date();
		String articleId = IdUtil.objectId();
		DtsArticle article = new DtsArticle();
		article.setArticleId(articleId);
		article.setCreateTime(date);
		article.setUpdateTime(date);
		article.setState(StateNum.notSubmit);
		article.setAuthorId(authorId);

		subject(subjectId, articleId);

		return articleRepository.save(article);
	}

	public DtsArticle saveArticle(String authorId, String title,String synopsis,String markdown, String html) {
		String markdownId = saveContext(markdown);
		String htmlId = saveContext(html);
		DateTime date = DateUtil.date();
		DtsArticle article = new DtsArticle();
		article.setTitle(title);
		article.setSynopsis(synopsis);
		article.setArticleId(IdUtil.objectId());
		article.setCreateTime(date);
		article.setUpdateTime(date);
		article.setState(StateNum.normal);
		article.setAuthorId(authorId);
		article.setMarkdownContextId(markdownId);
		article.setTextContextId(htmlId);

		return articleRepository.save(article);
	}


	public DtsArticle updateArticle(String articleId, String subjectId,String categoryId, String title, String text, String markdown) {

		String synopsis = StrUtil.sub(CommonUtil.delHTMLTag(text), 0, 150);
		String textContextId = saveContext(text);
		String markdownContextId = saveContext(markdown);

		DtsArticle article = articleRepository.findById(articleId).orElseThrow();
		article.setState(StateNum.normal);
		article.setTitle(title);
		article.setUpdateTime(DateUtil.date());
		article.setTextContextId(textContextId);
		article.setMarkdownContextId(markdownContextId);
		article.setCategoryId(categoryId);
		article.setSynopsis(synopsis);

		articleRepository.save(article);

		subject(subjectId, articleId);

		return article;
	}

	public void subject(String subjectId , String articleId){
		if (StrUtil.isNotBlank(subjectId)) {
			Integer orderNum = subjectRelevanceRepository.findMaxOrderNumBySubjectId(subjectId);
			if (orderNum == null) {
				orderNum = 0;
			}

			DtsSubjectRelevance subjectRelevance = subjectRelevanceRepository.findByDataId(articleId)
					.orElse(null);

			if (subjectRelevance == null) {
				DtsSubjectRelevance articleSubjectRelevance = new DtsSubjectRelevance();
				articleSubjectRelevance.setSubjectRelevanceId(IdUtil.objectId());
				articleSubjectRelevance.setDataId(articleId);
				articleSubjectRelevance.setSubjectId(subjectId);
				articleSubjectRelevance.setCreateTime(DateUtil.date());
				articleSubjectRelevance.setOrderNum(orderNum);
				subjectRelevanceRepository.save(articleSubjectRelevance);
			} else {
				subjectRelevanceRepository.delete(subjectRelevance);
				DtsSubjectRelevance articleSubjectRelevance = new DtsSubjectRelevance();
				articleSubjectRelevance.setSubjectRelevanceId(IdUtil.objectId());
				articleSubjectRelevance.setDataId(articleId);
				articleSubjectRelevance.setSubjectId(subjectId);
				articleSubjectRelevance.setOrderNum(orderNum);
				articleSubjectRelevance.setCreateTime(DateUtil.date());
				subjectRelevanceRepository.save(articleSubjectRelevance);
			}
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteByArticleIdAndAuthorId(String articleId, String authorId) {
		articleRepository.deleteByArticleIdAndAuthorId(articleId, authorId);
	}

	public DtsArticleDto selectArticleById(String articleId) {
		DtsArticle article = articleRepository.findById(articleId).orElseThrow();
		UtsAuthor author = authorRepository.findUsernameNicknameByAuthorId(article.getAuthorId()).orElseThrow();
		
		DtsArticleDto articleDto = new DtsArticleDto(article);
		articleDto.setAuthor(author);
		subjectRepository.findByDataId(articleId).ifPresent(articleDto::setSubject);
		contextRepository.findById(article.getTextContextId()).ifPresent(context -> articleDto.setText(context.getText()));
		return articleDto;
	}

	public DtsArticleDto selectArticleAllById(String articleId) {
		DtsArticle article = articleRepository.findById(articleId).orElseThrow();
		UtsAuthor author = authorRepository.findUsernameNicknameByAuthorId(article.getAuthorId()).orElseThrow();
		DtsSubject subject = subjectRepository.findByDataId(articleId).orElse(null);
		String textContextId = article.getTextContextId();
		String markdownContextId = article.getMarkdownContextId();

		DtsArticleDto articleDto = new DtsArticleDto(article);
		articleDto.setAuthor(author);
		articleDto.setSubject(subject);
		if(textContextId != null){
			contextRepository.findById(textContextId).ifPresent(context -> articleDto.setText(context.getText()));
		}
		if(markdownContextId != null){
			contextRepository.findById(markdownContextId).ifPresent(context -> articleDto.setMarkdown(context.getText()));
		}
		return articleDto;
	}

	public List<DtsArticle> selectArticleListRandom() {
		return articleRepository.randomArticle();
	}

	/**
	 * 保存文章专辑
	 */
	@Transactional(rollbackFor = Exception.class)
	public void saveSubjectId(String articleId, String subjectId) {

		subjectRelevanceRepository.deleteByDataId(articleId);

		List<DtsSubjectRelevance> subjectRelevanceList = subjectRelevanceRepository.findBySubjectId(subjectId);
		DateTime date = DateUtil.date();

		AtomicInteger index = new AtomicInteger(0);
		subjectRelevanceList = subjectRelevanceList.stream().map(subjectRelevance -> {
			subjectRelevance.setOrderNum(index.getAndIncrement());
			subjectRelevance.setUpdateTime(date);
			return subjectRelevance;
		}).collect(Collectors.toList());

		DtsSubjectRelevance subjectRelevance = new DtsSubjectRelevance();
		subjectRelevance.setSubjectRelevanceId(IdUtil.objectId());
		subjectRelevance.setSubjectId(subjectId);
		subjectRelevance.setDataId(articleId);
		subjectRelevance.setOrderNum(subjectRelevanceList.size());
		subjectRelevance.setCreateTime(date);
		subjectRelevance.setUpdateTime(date);
		subjectRelevanceList.add(subjectRelevance);

		subjectRelevanceRepository.saveAll(subjectRelevanceList);
	}

	/**
	 * 通过文章ID查询用户ID
	 */
	public String authorId(String articleId) {
		return articleRepository.findById(articleId).orElseThrow().getAuthorId();
	}

	/**
	 * 查询关注用户的文章
	 */
	public Page<DtsArticleDto> selectGzArticleList(Pageable pageable, String authorId) {
		Page<DtsArticle> gzArticleList = articleRepository.findFansArticleList(authorId, pageable);
		return gzArticleList.map(article -> {
			DtsArticleDto articleDto = new DtsArticleDto(article);
			authorRepository.findUsernameNicknameByAuthorId(article.getAuthorId()).ifPresent(author -> {
				articleDto.setAuthor(author);
			});
			return articleDto;
		});
	}

	/**
	 * 管理查询
	 */
	public Page<DtsArticleDto> findArticleList(Integer state, Pageable page) {
		Page<DtsArticle> articleList = articleRepository.findArticleListState(state, page);
		return articleList.map(article -> {
			DtsArticleDto articleDto = new DtsArticleDto(article);
			articleDto.setAuthor(authorRepository.findUsernameNicknameByAuthorId(article.getAuthorId()).orElseThrow());
			articleDto.setSubject(subjectRepository.findByDataId(article.getArticleId()).orElse(null));
			return articleDto;
		});
	}

	public void deleteArticleByArticleId(String articleId) {
		Optional<DtsArticle> findById = articleRepository.findById(articleId);
		DtsArticle article = findById.orElseThrow();
		article.setState(StateNum.delete);
		articleRepository.save(article);
	}

	public String saveContext(String text) {
		DtsContext context = new DtsContext();
		String contextId = IdUtil.objectId();
		context.setId(contextId);
		context.setText(text);
		context.setCreateTime(new Date());
		context.setUpdateTime(new Date());
		contextRepository.save(context);
		return contextId;
	}
}
