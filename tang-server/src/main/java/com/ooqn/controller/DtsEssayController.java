package com.ooqn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.exception.ApiException;
import com.ooqn.entity.dto.DtsEssayDto;
import com.ooqn.entity.model.DtsEssay;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.entity.param.DtsEssayParam;
import com.ooqn.service.DtsEssayService;

import cn.hutool.core.bean.BeanUtil;

@RestController
@RequestMapping("api/essay")
public class DtsEssayController extends BaseController {

	@Autowired
	private DtsEssayService essayService;

	@PostMapping
	public DtsEssayDto insert(@RequestBody DtsEssayParam essayParam) {
		DtsEssay essay = BeanUtil.toBean(essayParam, DtsEssay.class);
		essay.setAuthorId(authorId());
		essay.setType("essay");
		DtsEssay dtsEssay = essayService.insert(essay);
		if (dtsEssay != null) {
			DtsEssayDto dtsEssayDto = BeanUtil.toBean(essay, DtsEssayDto.class);
			UtsAuthor author = author();
			dtsEssayDto.setAuthor(author);
			return dtsEssayDto;
		}
		throw new ApiException("添加失败");
	}

	@GetMapping
	public Page<DtsEssayDto> select(@RequestParam(defaultValue = "0") Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		return essayService.findAllInfo(pageable);
	}

	@DeleteMapping("{essayId}")
	public void delete(@PathVariable("essayId") String essayId) {
		essayService.delete(essayId);
	}
}
