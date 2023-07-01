package com.ooqn.service;

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
import com.ooqn.entity.dto.DtsSubjectArticleDto;
import com.ooqn.entity.dto.DtsSubjectDto;
import com.ooqn.entity.model.DtsArticle;
import com.ooqn.entity.model.DtsArticleContext;
import com.ooqn.entity.model.DtsSubject;
import com.ooqn.entity.model.DtsSubjectRelevance;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.repository.DtsArticleContextRepository;
import com.ooqn.repository.DtsArticleRepository;
import com.ooqn.repository.DtsCategoryRepository;
import com.ooqn.repository.DtsSubjectRelevanceRepository;
import com.ooqn.repository.DtsSubjectRepository;
import com.ooqn.repository.UtsAuthorRepository;

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
	private DtsArticleContextRepository articleContextRepository;

	@Autowired
	private DtsSubjectRelevanceRepository subjectRelevanceRepository;

	@Autowired
	private DtsCategoryRepository categoryRepository;

	/**
	 * 查询这个专辑的所有文章
	 */
	public DtsSubjectArticleDto findSubjectArticleListBySubjectId(String subjectId) {
		List<DtsArticle> articleList = articleRepository.findSubjectById(subjectId);
		DtsSubject subject = subjectRepository.findById(subjectId).orElseThrow();
		UtsAuthor author = authorRepository.findUsernameNicknameByAuthorId(subject.getAuthorId()).orElseThrow();
		DtsSubjectArticleDto articleSubjectDto = new DtsSubjectArticleDto();
		articleSubjectDto.setArticleList(articleList);
		articleSubjectDto.setSubject(subject);
		articleSubjectDto.setAuthor(author);
		return articleSubjectDto;
	}

	/**
	 * 查询专辑链表
	 */

	public Page<DtsSubjectDto> selectSubjectList(Pageable pageable) {
		Page<DtsSubject> subjectPage = subjectRepository.findSubjectList(pageable);
		Page<DtsSubjectDto> subjectList = subjectPage.map(subject -> {
			String authorId = subject.getAuthorId();
			UtsAuthor author = authorRepository.findUsernameNicknameByAuthorId(authorId).orElseThrow();
			DtsSubjectDto subjectDto = new DtsSubjectDto();
			subjectDto.setSubject(subject);
			subjectDto.setAuthor(author);
			return subjectDto;
		});
		return subjectList;
	}

	/**
	 * 通过作者名称查询专辑列表
	 */
	public List<DtsSubject> selectSubjectListByUsername(String username) {
		return subjectRepository.findByAuthorName(username);
	}

	/**
	 * 添加专辑
	 */
	public DtsSubject insertSubject(DtsSubject subject) {
		DateTime date = DateUtil.date();
		subject.setSubjectId(IdUtil.objectId());
		subject.setCreateTime(date);
		subject.setUpdateDate(date);
		return subjectRepository.save(subject);
	}

	/**
	 * 更新专辑
	 */
	public DtsSubject updateSubject(DtsSubject subject) {
		DtsSubject articleSubject = subjectRepository.findById(subject.getSubjectId()).orElseThrow();
		articleSubject.setUpdateDate(DateUtil.date());
		articleSubject.setSubjectName(subject.getSubjectName());
		articleSubject.setSynopsis(subject.getSynopsis());
		return subjectRepository.save(articleSubject);
	}

	/**
	 * 通过专辑名称搜索专辑
	 */
	public Page<DtsSubjectDto> findSubjectListBySubjectName(String name, Pageable pageable) {
		Page<DtsSubject> subjectList = subjectRepository.findBySubjectName(name, pageable);
		Page<DtsSubjectDto> subjectDtoList = subjectList.map(subject -> {
			DtsSubjectDto subjectDto = new DtsSubjectDto();
			subjectDto.setSubject(subject);
			subjectDto.setAuthor(authorRepository.findUsernameNicknameByAuthorId(subject.getAuthorId()).orElseThrow());
			return subjectDto;
		});
		return subjectDtoList;
	}

	/**
	 * 通过专辑id查询专辑 
	 * @param articleId 文章id
	 * @return	SubjectId
	 */
	public String findSubjectIdByArticleId(String articleId) {
		return subjectRepository.findSubjectIdByDataId(articleId);
	}

	/**
	 * 通过专辑id查询专辑
	 * @param subjectId	专辑id
	 * @return	DtsSubject
	 */
	public DtsSubject subjectById(String subjectId) {
		return subjectRepository.findById(subjectId).orElseThrow();
	}

	/**
	 * 通过文章id查询专辑
	 * @param articleId 文章id
	 * @return List<DtsArticle>
	 */
	public List<DtsArticle> findSubjectArticleTitleListByArticleId(String articleId) {
		return articleRepository.findSubjectArticleTitleListByArticleId(articleId);
	}

	@Transactional
	public void deleteBySubjectIdAndAuthorId(String subjectId, String authorId) {
		subjectRepository.deleteBySubjectIdAndAuthorId(subjectId, authorId);
	}

	/**
	 * 通过文章id查询专辑
	 * @param categoryId 分类id
	 * @param pageable 分页
	 * @return Page<DtsArticleDto>
	 */
	public Page<DtsArticleDto> selectArticleList(String categoryId,Pageable pageable) {
		Page<DtsArticle> findArticleList;
		if(StrUtil.equals(categoryId, "0")){
			findArticleList = articleRepository.findArticleList(pageable);
		}else{
			findArticleList = articleRepository.findArticleListByCategoryId(categoryId, pageable);
		}
		return findArticleList.map(article -> {
			String authorId = article.getAuthorId();
			String articleCategoryId = article.getCategoryId();
			DtsArticleDto articleDto = new DtsArticleDto();
			articleDto.setArticle(article);

			if(articleCategoryId != null){
				categoryRepository.findById(articleCategoryId).ifPresent(articleDto::setCategory);
			}
			
			authorRepository.findById(authorId).ifPresent(articleDto::setAuthor);
			return articleDto;
		});
	}

	public Page<DtsArticleDto> selectArticleListSmall(Pageable pageable) {
		Page<DtsArticle> articlePage = articleRepository.findArticleListSmall(pageable);
		return articlePage.map( a -> {
			DtsArticleDto articleDto = new DtsArticleDto();
			articleDto.setArticle(a);
			articleDto.setAuthor(authorRepository.findUsernameNicknameByAuthorId(a.getAuthorId()).orElseThrow());
			return articleDto;
		});
	}

	public Page<DtsArticleDto> search(String title,Pageable pageable) {
		Page<DtsArticle> articlePage = articleRepository.search(title, pageable);
		return articlePage.map(article -> {
			DtsArticleDto articleDto = new DtsArticleDto();
			articleDto.setArticle(article);
			articleDto.setAuthor(authorRepository.findUsernameNicknameByAuthorId(article.getAuthorId()).orElseThrow());
			return articleDto;
		});
	}

	public Page<DtsArticleDto> selectArticleByAuthorName(String username, Pageable pageable) {
		Page<DtsArticle> articleList = articleRepository.findArticleListByUsername(username, pageable);
		return articleList.map(article -> {
			DtsArticleDto articleDto = new DtsArticleDto();
			articleDto.setArticle(article);
			articleDto.setAuthor(authorRepository.findUsernameNicknameByAuthorId(article.getAuthorId()).orElseThrow());
			articleDto.setSubject(subjectRepository.findByDataId(article.getArticleId()).orElse(null));
			String categoryId = article.getCategoryId();
			if(categoryId != null){
				categoryRepository.findById(categoryId).ifPresent(articleDto::setCategory);
			}
			return articleDto;
		});
	}

	public DtsArticle insertArticle(String authorId) {

		DateTime date = DateUtil.date();

		DtsArticle article = new DtsArticle();
		article.setArticleId(IdUtil.objectId());
		article.setCreateTime(date);
		article.setUpdateTime(date);
		article.setState(StateNum.notSubmit);
		article.setAuthorId(authorId);

		DtsArticleContext articleContext = new DtsArticleContext();
		articleContext.setArticleId(article.getArticleId());
		articleContext.setUpdateTime(date);
		articleContext.setCreateTime(date);
		articleContext.setMarkdown("");
		articleContext.setText("");

		articleContextRepository.save(articleContext);
		return articleRepository.save(article);
	}

	public DtsArticle updateArticle(DtsArticle article, String subjectId, String text, String markdown) {
		
		DtsArticle saveArticle = articleRepository.save(article);
		Optional<DtsArticleContext> articleContext = articleContextRepository.findById(article.getArticleId());

		articleContext.ifPresent(a -> {
			a.setText(text);
			a.setMarkdown(markdown);
			articleContextRepository.save(a);
		});

		if (subjectId == null) {
			return saveArticle;
		}

		Integer orderNum = subjectRelevanceRepository.findMaxOrderNumBySubjectId(subjectId);
		if(orderNum == null){
			orderNum = 0;
		}

		DtsSubjectRelevance subjectRelevance = subjectRelevanceRepository.findByDataId(article.getArticleId()).orElse(null);

		if(subjectRelevance == null){
			DtsSubjectRelevance articleSubjectRelevance = new DtsSubjectRelevance();
			articleSubjectRelevance.setSubjectRelevanceId(IdUtil.objectId());
			articleSubjectRelevance.setDataId(article.getArticleId());
			articleSubjectRelevance.setSubjectId(subjectId);
			articleSubjectRelevance.setCreateTime(DateUtil.date());
			articleSubjectRelevance.setOrderNum(orderNum);
			subjectRelevanceRepository.save(articleSubjectRelevance);
			return saveArticle;
		}else{
			subjectRelevanceRepository.delete(subjectRelevance);
			DtsSubjectRelevance articleSubjectRelevance = new DtsSubjectRelevance();
			articleSubjectRelevance.setSubjectRelevanceId(IdUtil.objectId());
			articleSubjectRelevance.setDataId(article.getArticleId());
			articleSubjectRelevance.setSubjectId(subjectId);
			articleSubjectRelevance.setOrderNum(orderNum);
			articleSubjectRelevance.setCreateTime(DateUtil.date());
			subjectRelevanceRepository.save(articleSubjectRelevance);
		}

		return saveArticle;
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteByArticleIdAndAuthorId(String articleId, String authorId) {
		articleContextRepository.deleteByArticleId(articleId);
		articleRepository.deleteByArticleIdAndAuthorId(articleId, authorId);
	}

	public DtsArticleDto selectArticleById(String articleId) {
		DtsArticleDto articleDto = new DtsArticleDto();
		DtsArticle article = articleRepository.findById(articleId).orElseThrow();
		UtsAuthor author = authorRepository.findUsernameNicknameByAuthorId(article.getAuthorId()).orElseThrow();
		DtsSubject subject = subjectRepository.findByDataId(articleId).orElse(null);

		String text = articleContextRepository.findById(articleId).orElseThrow().getText();

		DtsArticleContext articleContext = new DtsArticleContext();
		articleContext.setText(text);

		articleDto.setArticleContext(articleContext);
		articleDto.setArticle(article);
		articleDto.setAuthor(author);
		articleDto.setSubject(subject);
		return articleDto;
	}

	public DtsArticleDto selectArticleAllById(String articleId) {
		DtsArticleDto articleDto = new DtsArticleDto();
		DtsArticle article = articleRepository.findById(articleId).orElseThrow();
		UtsAuthor author = authorRepository.findUsernameNicknameByAuthorId(article.getAuthorId()).orElseThrow();
		DtsSubject subject = subjectRepository.findByDataId(articleId).orElse(null);

		articleDto.setArticleContext(articleContextRepository.findById(articleId).orElseThrow());
		articleDto.setArticle(article);
		articleDto.setAuthor(author);
		articleDto.setSubject(subject);
		return articleDto;
	}

	public DtsArticle selectArticleInfoById(String id) {
		return articleRepository.findById(id).orElseThrow();
	}

	public DtsArticle selectById(String id) {
		return articleRepository.findById(id).orElseThrow();
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
			DtsArticleDto articleDto = new DtsArticleDto();
			articleDto.setArticle(article);
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
		Page<DtsArticle> articleList = articleRepository.findArticleListState(state,page);
		return articleList.map(article -> {
			DtsArticleDto articleDto = new DtsArticleDto();
			articleDto.setArticle(article);
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
}
