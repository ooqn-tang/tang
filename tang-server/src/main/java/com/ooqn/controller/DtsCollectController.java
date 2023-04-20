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

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.ooqn.entity.model.DtsCollect;
import com.ooqn.entity.param.DtsCollectParam;
import com.ooqn.service.DtsCollectService;

@RestController
@RequestMapping("api/collect")
public class DtsCollectController extends BaseController {

	@Autowired
	private DtsCollectService collectService;

	@GetMapping("{dataId}")
	public Long collect(@PathVariable("dataId") String dataId) {
		String authorId = authorId();
		return collectService.select(authorId, dataId);
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
		DateTime date = DateUtil.date();
		String authorId = authorId();

		collect.setCollectId(IdUtil.objectId());
		collect.setAuthorId(authorId);
		collect.setCreateDate(date);
		return collectService.insert(collect);
	}

	@DeleteMapping("{dataId}")
	public void delete(@PathVariable("dataId") String dataId) {
		String authorId = authorId();
		collectService.unCollect(authorId, dataId);
	}
}
