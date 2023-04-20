package com.ooqn.controller;

import cn.hutool.core.bean.BeanUtil;
import com.ooqn.core.exception.ApiException;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.param.UtsAuthorParam;
import com.ooqn.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/author")
@Validated
public class UtsAuthorController extends BaseController {

	@Autowired
	private UtsAuthorService authorService;

	@GetMapping("selectAuthor")
	public Page<UtsAuthor> select(@RequestParam(value = "page", defaultValue = "0") Integer page) {
		Pageable pageable = PageRequest.of(page, 100);
		return authorService.selectAuthor(pageable);
	}

	@PutMapping
	public String update(@RequestBody UtsAuthorParam authorParam) {
		UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);
		String authorId = authorId();
		author.setAuthorId(authorId);
		UtsAuthor update = authorService.update(author);
		if (update != null) {
			return "更新成功";
		}
		throw new ApiException();
	}

	@GetMapping("{username}")
	public UtsAuthor authorByUsername(@PathVariable(value = "username") String username) {
		return authorService.selectAuthorByName(username);
	}

	@GetMapping("list")
	public Page<UtsAuthor> authorList(
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		return authorService.selectAuthor(pageable);
	}
}