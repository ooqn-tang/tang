package cn.ttcxy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.StateNum;
import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleSubject;
import cn.ttcxy.entity.model.DtsArticleSubjectRelevance;
import cn.ttcxy.repository.DtsArticleRepository;
import cn.ttcxy.repository.DtsArticleSubjectRelevanceRepository;
import cn.ttcxy.repository.DtsArticleSubjectRepository;

/**
 * 文章于文章专辑相关
 */
@Service
public class DtsArticleSubjectService {
	
	private static List<DtsArticleDto> cache = new ArrayList<>();

	@Autowired
	private DtsArticleSubjectRepository articleSubjectRepository;
	
	@Autowired
	private DtsArticleSubjectRelevanceRepository dtsArticleSubjectRepository;

	@Autowired
	private DtsArticleRepository articleRepository;

	@Autowired
	private DtsArticleSubjectRelevanceRepository subjectRelevanceRepository;

	@Autowired
	private DtsArticleRepository articlerRepository;

	/**
	 * 查询这个专辑的所有文章
	 */
	public DtsArticleSubjectDto findSubjectArticleListBySubjectId(String subjectId) {
		DtsArticleSubjectDto dtsArticleSubjectDto = articlerRepository.findSubjectById(subjectId);
		if (dtsArticleSubjectDto == null) {
			return null;
		}
		List<DtsArticle> dtsArticles = articlerRepository.findSubjectArticleListBySubjectId(subjectId);
		dtsArticleSubjectDto.setArticleList(dtsArticles);
		return dtsArticleSubjectDto;
	}

	/**
	 * 查询专辑链表
	 */
	public Page<DtsArticleSubjectDto> selectSubjectList(Pageable pageable) {
		return articleSubjectRepository.findSubjectList(pageable);
	}

	/**
	 * 通过作者名称查询专辑列表
	 */
	public List<DtsArticleSubjectDto> selectSubjectListByUsername(String username) {
		return articleSubjectRepository.findSubjectListByUsername(username);
	}

	/**
	 * 添加专辑
	 */
	public DtsArticleSubject insertSubject(DtsArticleSubject subject) {
		subject.setSubjectId(IdUtil.objectId());
		DateTime date = DateUtil.date();
		subject.setCreateDate(date);
		subject.setUpdateDate(date);
		return articleSubjectRepository.save(subject);
	}

	/**
	 * 更新专辑
	 */
	public DtsArticleSubject updateSubject(DtsArticleSubject subject) {
		DtsArticleSubject articleSubject =
				articleSubjectRepository.findById(subject.getSubjectId()).orElseThrow();
		articleSubject.setUpdateDate(DateUtil.date());
		articleSubject.setSubjectName(subject.getSubjectName());
		articleSubject.setSynopsis(subject.getSynopsis());
		return articleSubjectRepository.save(articleSubject);
	}

	/**
	 * 通过专辑名称搜索专辑
	 */
	public Page<DtsArticleSubjectDto> findSubjectListBySubjectName(String name,Pageable pageable) {
		return articleSubjectRepository.findSubjectListBySubjectName(name, pageable);
	}

	public String findSubjectIdByArticleId(String articleId) {
		return articleSubjectRepository.findSubjectIdByArticleId(articleId);
	}

	public DtsArticleSubject subjectById(String subjectId) {
		return articleSubjectRepository.findById(subjectId).orElseThrow();
	}

	public List<DtsArticle> findSubjectArticleTitleListByArticleId(String articleId) {
		String subjectId = findSubjectIdByArticleId(articleId);
		return articleSubjectRepository.findSubjectArticleTitleListBySubjectId(subjectId);
	}

	public void deleteBySubjectIdAndAuthorId(String subjectId, String authorId) {
		articleSubjectRepository.deleteBySubjectIdAndAuthorId(subjectId, authorId);
	}

	public Page<DtsArticleDto> selectArticleList(Pageable pageable) {
		return articleRepository.findArticleList(pageable);
	}

	public Page<DtsArticleDto> selectArticleListSmall(Pageable pageable) {
		return articleRepository.findArticleListSmall(pageable);
	}

	public Page<DtsArticleDto> search(String title, Integer page, Integer pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize);
		return articleRepository.search(title, pageable);
	}

	public Page<DtsArticleDto> selectArticleByAuthorName(String username, Pageable pageable) {
		return articleRepository.findArticleListByUsername(username, pageable);
	}

	public DtsArticle insertArticle(DtsArticle article) {
		return articleRepository.save(article);
	}

	public DtsArticle updateArticle(DtsArticle article, String subjectId) {
		DtsArticle saveArticle = articleRepository.save(article);
		DtsArticleSubjectRelevance articleSubjectRelevance =
				subjectRelevanceRepository.findByArticleId(article.getArticleId());

		if (articleSubjectRelevance == null) {
			articleSubjectRelevance = new DtsArticleSubjectRelevance();
			articleSubjectRelevance.setArticleId(article.getArticleId());
			articleSubjectRelevance.setSubjectId(subjectId);
			articleSubjectRelevance.setCreateDate(DateUtil.date());
		}
		subjectRelevanceRepository.save(articleSubjectRelevance);
		return saveArticle;
	}

	public void deleteByArticleIdAndAuthorId(String articleId, String authorId) {
		articleRepository.deleteByArticleIdAndAuthorId(articleId, authorId);
	}

	public DtsArticleDto selectArticleById(String id) {
		return articleRepository.findArticle(id);
	}

	public DtsArticle selectArticleInfoById(String id) {
		return articleRepository.findById(id).orElseThrow();
	}

	public DtsArticle selectById(String id) {
		return articleRepository.findById(id).orElseThrow();
	}

	public List<DtsArticleDto> selectArticleListRandom() {
		List<DtsArticleDto> set = new ArrayList<>();
		cache = articleRepository.findArticleList1000();
		while (set.size() <= 10) {
			Random random = new Random();
			int n = random.nextInt(cache.size());
			DtsArticleDto dtsArticleDto = cache.get(n);
			set.add(dtsArticleDto);
		}
		return set;
	}

	/**
	 * 保存文章专辑
	 */
	public DtsArticleSubjectRelevance saveSubjectId(String articleId, String subjectId) {
		DtsArticleSubjectRelevance articleSubjectRelevance = new DtsArticleSubjectRelevance();
		articleSubjectRelevance.setArticleId(articleId);
		articleSubjectRelevance.setSubjectId(subjectId);
		return dtsArticleSubjectRepository.save(articleSubjectRelevance);
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
		return articleRepository.findGzArticleList(authorId, pageable);
	}

	/**
	 * 管理查询
	 */
    public Page<DtsArticleDto> findArticleList(Integer state,Pageable page) {
        return articleRepository.findArticleListState(state,page);
    }

	public void deleteArticleByArticleId(String articleId) {
		Optional<DtsArticle> findById = articleRepository.findById(articleId);
		DtsArticle article = findById.orElseThrow();
		article.setState(StateNum.delete);
		articleRepository.save(article);
	}
}
