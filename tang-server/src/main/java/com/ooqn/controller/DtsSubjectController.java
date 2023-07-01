package com.ooqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
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
import com.ooqn.core.exception.ApiException;
import com.ooqn.entity.dto.DtsSubjectArticleDto;
import com.ooqn.entity.dto.DtsSubjectDto;
import com.ooqn.entity.model.DtsArticle;
import com.ooqn.entity.model.DtsSubject;
import com.ooqn.entity.param.DtsSubjectParam;
import com.ooqn.service.DtsArticleSubjectService;
import com.ooqn.service.DtsSubjectService;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("api/subject")
@Validated
@Schema(name = "专题")
public class DtsSubjectController extends BaseController {

	@Autowired
	private DtsArticleSubjectService articleSubjectService;

	@Autowired
	private DtsSubjectService subjectService;

	@GetMapping("username/{username}")
	public List<DtsSubject> selectSubjectArticleListByUsername(
			@PathVariable(value = "username") String username) {
		return subjectService.selectListByUsername(username);
	}

	@GetMapping("id/{subjectId}")
	public DtsSubjectArticleDto selectSubjectArticleById(@PathVariable(value = "subjectId") String subjectId) {
		return articleSubjectService.findSubjectArticleListBySubjectId(subjectId);
	}

	@DeleteMapping("{subjectId}")
	public void deleteSubjectById(@PathVariable(value = "subjectId") String subjectId) {
		subjectService.deleteBySubjectIdAndAuthorId(subjectId, authorId());
	}

	@GetMapping("list")
	public Page<DtsSubjectDto> selectSubject(
			@RequestParam(value = "page", defaultValue = "0") Integer page) {
		Pageable pageable = PageRequest.of(page, 20);
		return subjectService.selectList(pageable);
	}

	@GetMapping("search")
	public Page<DtsSubjectDto> selectSubjectByName(@RequestParam(value = "subjectName", defaultValue = "") String name) {
		Pageable pageable = PageRequest.of(1, 15);
		return subjectService.findListBySubjectName(name, pageable);
	}

	@PostMapping
	public DtsSubject insertSubject(@RequestBody DtsSubjectParam subjectParam) {
		DtsSubject subjectDto = BeanUtil.toBean(subjectParam, DtsSubject.class);
		String authorId = authorId();
		subjectDto.setAuthorId(authorId);
		return subjectService.insert(subjectDto);
	}

	@PutMapping
	public String updateSubject(@RequestBody DtsSubjectParam subjectParam) {
		DtsSubject subject = BeanUtil.toBean(subjectParam, DtsSubject.class);
		subject = subjectService.update(subject);
		if (subject != null) {
			return "处理成功";
		}
		throw new ApiException();
	}

	@PutMapping("article")
	public void insertArticleToSubject(
			@RequestParam(value = "articleId") String articleId,
			@RequestParam(value = "subjectId") String subjectId) {
		articleSubjectService.saveSubjectId(articleId, subjectId);
	}

	@GetMapping("article/{articleId}")
	public List<DtsArticle> findSubjectListByArticleId(
			@PathVariable("articleId") String articleId) {
		return articleSubjectService.findSubjectArticleTitleListByArticleId(articleId);
	}
}
