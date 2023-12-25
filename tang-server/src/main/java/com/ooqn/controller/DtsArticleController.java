package com.ooqn.controller;

import java.util.List;
import java.util.Map;

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

import com.ooqn.core.control.BaseController;
import com.ooqn.core.security.NotLogin;
import com.ooqn.entity.dto.DtsArticleDto;
import com.ooqn.entity.model.DtsArticle;
import com.ooqn.entity.param.DtsArticleParam;
import com.ooqn.service.DtsArticleSubjectService;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/article")
@Tag(name = "文章")
public class DtsArticleController extends BaseController {

	
	// 创建Markdown解析器
	private Parser parser = Parser.builder().build();

	// 创建HTML渲染器
	private HtmlRenderer renderer = HtmlRenderer.builder().build();

	@Autowired
	private DtsArticleSubjectService articleSubjectService;

	@NotLogin
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

	@NotLogin
	@GetMapping("list/{username}")
	public Page<DtsArticleDto> selectArticleListByUsername(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@PathVariable(value = "username") String username) {
		Pageable pageable = PageRequest.of(page, 10);
		return articleSubjectService.selectArticleByAuthorName(username, pageable);
	}

	@NotLogin
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
		String articleId = articleParam.getArticleId();
		String text = articleParam.getText();
		String title = articleParam.getTitle();
		String markdown = articleParam.getMarkdown();
		String subjectId = articleParam.getSubjectId();
		String categoryId = articleParam.getCategoryId();
		String authorId = articleSubjectService.authorId(articleId);
		if (StrUtil.equals(authorId, authorId())) {
			articleSubjectService.updateArticle(articleId, subjectId,categoryId, title, text, markdown);
		}
	}

	@NotLogin
	@GetMapping("load/{articleId}")
	public DtsArticleDto load(@PathVariable(name = "articleId") String articleId) {
		return articleSubjectService.selectArticleById(articleId);
	}

	@NotLogin
	@GetMapping("load/{articleId}/all")
	public DtsArticleDto loadAll(@PathVariable(name = "articleId") String articleId) {
		return articleSubjectService.selectArticleAllById(articleId);
	}

	@NotLogin
	@GetMapping("so")
	public Page<?> search(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam("wb") String wb) {
		Pageable pageable = PageRequest.of(page, 10);
		return articleSubjectService.search(wb, pageable);
	}


	@NotLogin
	@PostMapping("ai")
	public String postMethodName(@RequestBody Map<String,String> entity) {
		String title = entity.get("title");
		String markdown = entity.get("markdown");
        // 将Markdown文本解析为HTML
        String html = renderer.render(parser.parse(markdown));
		String synopsis = entity.get("synopsis");
		DtsArticle saveArticle = articleSubjectService.saveArticle("fdf084f19c014b6691b63fc339126d56", title,synopsis,markdown,html);
		return saveArticle.getArticleId();
	}

	
}
