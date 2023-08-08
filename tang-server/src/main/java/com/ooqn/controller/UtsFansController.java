package com.ooqn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.BaseController;
import com.ooqn.core.exception.ApiException;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.model.UtsFans;
import com.ooqn.service.UtsAuthorService;
import com.ooqn.service.UtsFansService;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 粉丝
 */
@RestController
@RequestMapping("api/fans")
@Tag(name = "粉丝")
public class UtsFansController extends BaseController {

	@Autowired
	private UtsFansService fansService;

	@Autowired
	private UtsAuthorService authorService;

	@GetMapping("username/{username}")
	public Long selectByUsername(@PathVariable("username") String username) {
		String authorId = authorId();
		UtsAuthor utsAuthor = authorService.selectAuthorByName(username);
		if (utsAuthor != null) {
			return fansService.isFans(authorId, utsAuthor.getAuthorId());
		}
		throw new ApiException();
	}

	@GetMapping("list")
	public Page<UtsAuthor> selectList() {
		String authorId = authorId();
		Pageable pageable = PageRequest.of(0, 20);
		return fansService.selectFansList(authorId, pageable);
	}

	@PostMapping("{fansName}")
	public UtsFans insert(@PathVariable("fansName") String fansName) {
		String authorId = authorId();
		return fansService.insertFans(fansName, authorId);
	}

	@DeleteMapping("{fansName}")
	public Integer delete(@PathVariable("fansName") String fansName) {
		String authorId = authorId();
		return fansService.deleteFans(fansName, authorId);
	}
}
