package com.ooqn.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.control.BaseController;
import com.ooqn.entity.model.StsNotice;
import com.ooqn.service.StsNoticeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/admin/notice")
@Tag(name = "公告管理")
public class AdminNoticeController extends BaseController {

	@Autowired
	private StsNoticeService noticeService;

	@PostMapping
	public StsNotice insert(@RequestBody StsNotice notice) {
		return noticeService.insertNotice(notice,author());
	}

	@PutMapping
	public StsNotice update(@RequestBody StsNotice notice) {
		return noticeService.updateNotice(notice);
	}

	@PutMapping("order")
	public void updateOrder(@RequestBody StsNotice[] noticeList) {
		noticeService.updateNoticeOrder(noticeList);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		noticeService.deleteNotice(id);
	}

	@GetMapping
	public List<StsNotice> select() {
		return noticeService.selectAllNotice();
	}
}
