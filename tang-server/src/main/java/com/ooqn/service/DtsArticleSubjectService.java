package com.ooqn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ooqn.entity.StateNum;
import com.ooqn.entity.dto.DtsArticleDto;
import com.ooqn.entity.dto.DtsArticleSubjectDto;
import com.ooqn.entity.model.DtsArticle;
import com.ooqn.entity.model.DtsSubject;
import com.ooqn.entity.model.DtsSubjectRelevance;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.repository.DtsArticleRepository;
import com.ooqn.repository.DtsSubjectRelevanceRepository;
import com.ooqn.repository.DtsSubjectRepository;
import com.ooqn.repository.UtsAuthorRepository;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;

/**
 * 文章于文章专辑相关
 */
@Service
public class DtsArticleSubjectService {

	private static List<DtsArticleDto> cache = new ArrayList<>();

	@Autowired
	private UtsAuthorRepository authorRepository;

	@Autowired
	private DtsSubjectRepository subjectRepository;

	@Autowired
	private DtsArticleRepository articleRepository;

	@Autowired
	private DtsSubjectRelevanceRepository subjectRelevanceRepository;

	/**
	 * 查询这个专辑的所有文章
	 */
	public DtsArticleSubjectDto findSubjectArticleListBySubjectId(String subjectId) {
		List<DtsArticle> articleList = articleRepository.findSubjectById(subjectId);
		DtsSubject subject = subjectRepository.findById(subjectId).orElseThrow();
		UtsAuthor author = authorRepository.findById(subject.getAuthorId()).orElseThrow();
		DtsArticleSubjectDto articleSubjectDto = new DtsArticleSubjectDto();
		articleSubjectDto.setArticleList(articleList);
		articleSubjectDto.setSubject(subject);
		articleSubjectDto.setAuthor(author);
		return articleSubjectDto;
	}

	/**
	 * 查询专辑链表
	 */
	public Page<DtsArticleSubjectDto> selectSubjectList(Pageable pageable) {
		return null;// articleSubjectRepository.findSubjectList(pageable);
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
		subject.setSubjectId(IdUtil.objectId());
		DateTime date = DateUtil.date();
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
	public Page<DtsArticleSubjectDto> findSubjectListBySubjectName(String name, Pageable pageable) {
		return null;// articleSubjectRepository.findSubjectListBySubjectName(name, pageable);
	}

	public String findSubjectIdByArticleId(String articleId) {
		return null;// articleSubjectRepository.findSubjectIdByArticleId(articleId);
	}

	public DtsSubject subjectById(String subjectId) {
		return subjectRepository.findById(subjectId).orElseThrow();
	}

	public List<DtsArticle> findSubjectArticleTitleListByArticleId(String articleId) {
		String subjectId = findSubjectIdByArticleId(articleId);
		return null;// articleSubjectRepository.findSubjectArticleTitleListBySubjectId(subjectId);
	}

	public void deleteBySubjectIdAndAuthorId(String subjectId, String authorId) {
		// articleSubjectRepository.deleteBySubjectIdAndAuthorId(subjectId, authorId);
	}

	public Page<DtsArticleDto> selectArticleList(Pageable pageable) {
		return null;// articleRepository.findArticleList(pageable);
	}

	public Page<DtsArticleDto> selectArticleListSmall(Pageable pageable) {
		return null;// articleRepository.findArticleListSmall(pageable);
	}

	public Page<DtsArticleDto> search(String title, Integer page, Integer pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize);
		return null;// articleRepository.search(title, pageable);
	}

	public Page<DtsArticleDto> selectArticleByAuthorName(String username, Pageable pageable) {
		Page<DtsArticle> articleList = articleRepository.findArticleListByUsername(username, pageable);
		Page<DtsArticleDto> articleDtoList = articleList.map(article -> {
			DtsArticleDto articleDto = new DtsArticleDto();
			articleDto.setArticle(article);
			articleDto.setAuthor(authorRepository.findById(article.getAuthorId()).orElseThrow());
			articleDto.setSubject(subjectRepository.findByDataId(article.getArticleId()).orElse(null));
			return articleDto;
		});
		return articleDtoList;
	}

	public DtsArticle insertArticle(DtsArticle article) {
		return articleRepository.save(article);
	}

	public DtsArticle updateArticle(DtsArticle article, String subjectId, String classId, String tagId) {
		DtsArticle saveArticle = articleRepository.save(article);
		DtsSubjectRelevance articleSubjectRelevance = subjectRelevanceRepository.findByDataId(article.getArticleId());

		if (subjectId == null) {
			return saveArticle;
		}
		if (articleSubjectRelevance == null) {
			articleSubjectRelevance = new DtsSubjectRelevance();
			articleSubjectRelevance.setSubjectRelevanceId(IdUtil.objectId());
			articleSubjectRelevance.setDataId(article.getArticleId());
			articleSubjectRelevance.setSubjectId(subjectId);
			articleSubjectRelevance.setCreateTime(DateUtil.date());
		}
		subjectRelevanceRepository.save(articleSubjectRelevance);
		return saveArticle;
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteByArticleIdAndAuthorId(String articleId, String authorId) {
		articleRepository.deleteByArticleIdAndAuthorId(articleId, authorId);
	}

	public DtsArticleDto selectArticleById(String articleId) {
		DtsArticleDto articleDto = new DtsArticleDto();
		DtsArticle article = articleRepository.findById(articleId).orElseThrow();
		UtsAuthor author = authorRepository.findById(article.getAuthorId()).orElseThrow();
		DtsSubject subject = subjectRepository.findByDataId(articleId).orElse(null);
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

	public List<DtsArticleDto> selectArticleListRandom() {
		List<DtsArticleDto> set = new ArrayList<>();
		return set;
	}

	/**
	 * 保存文章专辑
	 */
	public void saveSubjectId(String articleId, String subjectId) {
		List<DtsSubjectRelevance> subjectRelevanceList = subjectRelevanceRepository.findBySubjectId(subjectId);
		DateTime date = DateUtil.date();
		AtomicInteger index = new AtomicInteger(0);
		subjectRelevanceList = subjectRelevanceList.stream().map(subjectRelevance -> {
			subjectRelevance.setOrderNum(index.getAndIncrement());
			subjectRelevance.setUpdateTime(date);
			return subjectRelevance;
		}).collect(Collectors.toList());

		// subjectRelevanceList 中是否包含 articleId
		boolean contains = subjectRelevanceList.stream()
				.anyMatch(subjectRelevance -> subjectRelevance.getDataId().equals(articleId));

		if (!contains) {
			DtsSubjectRelevance subjectRelevance = new DtsSubjectRelevance();
			subjectRelevance.setSubjectRelevanceId(IdUtil.objectId());
			subjectRelevance.setSubjectId(subjectId);
			subjectRelevance.setDataId(articleId);
			subjectRelevance.setOrderNum(subjectRelevanceList.size());
			subjectRelevance.setCreateTime(date);
			subjectRelevance.setUpdateTime(date);
			subjectRelevanceList.add(subjectRelevance);
		}
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
		return null;// articleRepository.findGzArticleList(authorId, pageable);
	}

	/**
	 * 管理查询
	 */
	public Page<DtsArticleDto> findArticleList(Integer state, Pageable page) {
		return null;// articleRepository.findArticleListState(state,page);
	}

	public void deleteArticleByArticleId(String articleId) {
		Optional<DtsArticle> findById = articleRepository.findById(articleId);
		DtsArticle article = findById.orElseThrow();
		article.setState(StateNum.delete);
		articleRepository.save(article);
	}
}
