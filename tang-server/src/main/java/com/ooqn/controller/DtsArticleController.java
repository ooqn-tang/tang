package com.ooqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.BaseController;
import com.ooqn.core.security.NotRole;
import com.ooqn.entity.StateNum;
import com.ooqn.entity.dto.DtsArticleDto;
import com.ooqn.entity.model.DtsArticle;
import com.ooqn.entity.param.DtsArticleParam;
import com.ooqn.service.DtsArticleSubjectService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/article")
@Tag(name = "文章")
public class DtsArticleController extends BaseController {

	@Autowired
	private DtsArticleSubjectService articleSubjectService;

	@NotRole
	@GetMapping("list")
	public Page<DtsArticleDto> selectArticleList(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "categoryId", defaultValue = "0") String categoryId) {
		Pageable pageable = PageRequest.of(page, 15);
		return articleSubjectService.selectArticleList(categoryId, pageable);
	}

	@GetMapping("list/gz")
	public Page<DtsArticleDto> selectArticleListGz(
			@RequestParam(value = "page", defaultValue = "0") Integer page) {
		Pageable pageable = PageRequest.of(page, 15);
		return articleSubjectService.selectGzArticleList(pageable, authorId());
	}

	@NotRole
	@GetMapping("list/{username}")
	public Page<DtsArticleDto> selectArticleListByUsername(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@PathVariable(value = "username") String username) {
		Pageable pageable = PageRequest.of(page, 10);
		return articleSubjectService.selectArticleByAuthorName(username, pageable);
	}

	@NotRole
	@GetMapping("recommend")
	public List<DtsArticle> selectArticleListRecommend() {
		return articleSubjectService.selectArticleListRandom();
	}

	@DeleteMapping("{articleId}")
	public ResponseEntity<String> delete(@PathVariable("articleId") String articleId) {
		String authorId = articleSubjectService.authorId(articleId);
		if (StrUtil.equals(authorId, authorId())) {
			articleSubjectService.deleteByArticleIdAndAuthorId(articleId, authorId());
		}
		return ResponseEntity.ok("处理成功");
	}

	@PostMapping
	public String create() {
		String authorId = authorId();
		DtsArticle article = articleSubjectService.insertArticle(authorId);
		return article.getArticleId();
	}

	@PutMapping
	public void update(@RequestBody DtsArticleParam articleParam) {
		DtsArticle article = BeanUtil.toBean(articleParam, DtsArticle.class);
		String articleId = article.getArticleId();
		String authorId = articleSubjectService.authorId(articleId);
		String text = articleParam.getText();
		String title = articleParam.getTitle();
		String markdown = articleParam.getMarkdown();
		String subjectId = articleParam.getSubjectId();
		if (StrUtil.equals(authorId, authorId())) {
			article.setAuthorId(authorId);
			article.setState(StateNum.normal);
			article.setUpdateTime(DateUtil.date());
			articleSubjectService.updateArticle(articleId, subjectId, title, text, markdown);
		}
	}

	@NotRole
	@GetMapping("load/{articleId}")
	public DtsArticleDto load(@PathVariable(name = "articleId") String articleId) {
		return articleSubjectService.selectArticleById(articleId);
	}

	@NotRole
	@GetMapping("load/{articleId}/all")
	public DtsArticleDto loadAll(@PathVariable(name = "articleId") String articleId) {
		return articleSubjectService.selectArticleAllById(articleId);
	}

	@NotRole
	@GetMapping("so")
	public Page<?> search(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam("wb") String wb) {
		Pageable pageable = PageRequest.of(page, 10);
		return articleSubjectService.search(wb, pageable);
	}
}
