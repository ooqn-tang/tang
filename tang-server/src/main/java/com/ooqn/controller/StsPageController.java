package com.ooqn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ooqn.core.security.NotRole;
import com.ooqn.entity.dto.DtsArticleDto;
import com.ooqn.entity.dto.DtsSubjectDto;
import com.ooqn.service.DtsArticleSubjectService;
import com.ooqn.service.DtsSubjectService;
import com.ooqn.service.StsNoticeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@RequestMapping
@Tag(name = "页面")
public class StsPageController {

	@Autowired
	private DtsArticleSubjectService articleSubjectService;

	@Autowired
	private DtsSubjectService subjectService;

	@Autowired
	private StsNoticeService noticeService;

	@NotRole
	@GetMapping
	public String toIndex(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
		Pageable pageable = PageRequest.of(page, 50);
		Page<DtsArticleDto> articlePage = articleSubjectService.selectArticleListSmall(pageable);
		model.addAttribute("articlePage", articlePage);
		model.addAttribute("notice", noticeService.selectAllNotice());
		return "articles";
	}

	@NotRole
	@GetMapping("article/{id}")
	public String toArticle(@PathVariable("id") String id, Model model) {
		DtsArticleDto articleDto = articleSubjectService.selectArticleById(id);
		model.addAttribute("article", articleDto);
		String subjectId = subjectService.findSubjectIdByArticleId(id);
		if (subjectId != null) {
			DtsSubjectDto subject = articleSubjectService.findSubjectArticleListBySubjectId(subjectId);
			model.addAttribute("subject", subject);
		}

		model.addAttribute("notice", noticeService.selectAllNotice());
		return "article";
	}

	@NotRole
	@GetMapping("map")
	public String map(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
		Pageable pageable = PageRequest.of(page, 15);
		Page<DtsArticleDto> articlePage = articleSubjectService.selectArticleList("0", pageable);
		model.addAttribute("articlePage", articlePage);
		return "map";
	}

	@NotRole
	@GetMapping("subject/{id}")
	public String subject(@PathVariable("id") String id, Model model) {
		DtsSubjectDto subject = articleSubjectService.findSubjectArticleListBySubjectId(id);
		model.addAttribute("subject", subject);
		return "subject";
	}

	@NotRole
	@GetMapping("subjects")
	public String subjects(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {
		Pageable pageable = PageRequest.of(page, 50);
		Page<DtsSubjectDto> subjects = subjectService.selectList(pageable);
		model.addAttribute("subjects", subjects);
		return "subjects";
	}

}
