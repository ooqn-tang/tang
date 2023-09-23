package com.ooqn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.control.BaseController;
import com.ooqn.entity.model.DtsLike;
import com.ooqn.service.DtsLikeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/like")
@Tag(name = "点赞")
public class DtsLikeController extends BaseController {

	@Autowired
	private DtsLikeService likeService;

	@PostMapping("{dataId}")
	public DtsLike like(@PathVariable("dataId") String dataId) {
		return likeService.insert(dataId, authorId());
	}

	@DeleteMapping("{dataId}")
	public void unlike(@PathVariable("dataId") String dataId) {
		likeService.delete(dataId, authorId());
	}

	@GetMapping("{dataId}")
	public Long select(@PathVariable("dataId") String dataId) {
		return likeService.select(dataId, authorId());
	}
}
