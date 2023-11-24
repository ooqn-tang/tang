package com.ooqn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.control.BaseController;
import com.ooqn.entity.model.DtsCollect;
import com.ooqn.entity.param.DtsCollectParam;
import com.ooqn.service.DtsCollectService;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/collect")
@Tag(name = "收藏")
public class DtsCollectController extends BaseController {

	@Autowired
	private DtsCollectService collectService;

	@GetMapping
	public Long collect(@RequestParam("url") String url) {
		String authorId = authorId();
		return collectService.select(url, authorId);
	}

	@GetMapping("list")
	public Page<DtsCollect> list(@RequestParam("page") Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		String authorId = authorId();
		return collectService.selectCollect(authorId, pageable);
	}

	@PostMapping
	public DtsCollect insert(@RequestBody DtsCollectParam collectParam) {
		DtsCollect collect = BeanUtil.toBean(collectParam, DtsCollect.class);
		String authorId = authorId();
		return collectService.insert(collect, authorId);
	}

	@DeleteMapping
	public void unCollect(@RequestParam("url") String url) {
		String authorId = authorId();
		collectService.unCollect(url, authorId);
	}
}
