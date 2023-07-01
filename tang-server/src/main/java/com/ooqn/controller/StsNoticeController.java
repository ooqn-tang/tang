package com.ooqn.controller;

import com.ooqn.core.BaseController;
import com.ooqn.entity.model.StsNotice;
import com.ooqn.service.StsNoticeService;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notice")
@Schema(name = "公告")
public class StsNoticeController extends BaseController {

	@Autowired
	private StsNoticeService noticeService;

	@GetMapping("list")
	public List<StsNotice> select() {
		return noticeService.selectAllNotice();
	}
}
