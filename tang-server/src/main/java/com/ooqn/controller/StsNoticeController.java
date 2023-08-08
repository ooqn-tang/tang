package com.ooqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.BaseController;
import com.ooqn.core.security.NotRole;
import com.ooqn.entity.model.StsNotice;
import com.ooqn.service.StsNoticeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/notice")
@Tag(name = "公告")
public class StsNoticeController extends BaseController {

	@Autowired
	private StsNoticeService noticeService;

	@NotRole
	@GetMapping("list")
	public List<StsNotice> select() {
		return noticeService.selectAllNotice();
	}
}
