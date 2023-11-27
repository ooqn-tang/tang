package com.ooqn.controller;

import java.util.List;

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

import com.ooqn.core.control.BaseController;
import com.ooqn.core.security.NotLogin;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsRole;
import com.ooqn.entity.param.UtsAuthorParam;
import com.ooqn.service.UtsAuthorService;
import com.ooqn.service.UtsUserDetailsService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/author")
@Validated
@Tag(name = "作者")
public class UtsAuthorController extends BaseController {

	@Autowired
	private UtsAuthorService authorService;

    @Autowired
    private UtsUserDetailsService utsUserDetailsService;

	@GetMapping
    public UtsAuthor loadAuthor() {
        return author();
    }

	@NotLogin
	@GetMapping("selectAuthor")
	public Page<UtsAuthor> select(@RequestParam(value = "page", defaultValue = "0") Integer page) {
		Pageable pageable = PageRequest.of(page, 100);
		return authorService.selectAuthor(pageable);
	}

	@PutMapping
	public UtsAuthor update(@RequestBody UtsAuthorParam authorParam) {
		String authorId = authorId();
		String nickname = authorParam.getNickname();
		String signature = authorParam.getSignature();
		return authorService.update(authorId, nickname, signature);
	}

	@NotLogin
	@GetMapping("username/{username}")
	public UtsAuthor authorByUsername(@PathVariable(value = "username") String username) {
		return authorService.selectAuthorByName(username);
	}

	@NotLogin
	@GetMapping("list")
	public Page<UtsAuthor> authorList(
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		return authorService.selectAuthor(pageable);
	}

	@GetMapping("role/list")
	public List<UtsRole> authorRoles(
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		return utsUserDetailsService.loadRoles(authorName());

	}
}
