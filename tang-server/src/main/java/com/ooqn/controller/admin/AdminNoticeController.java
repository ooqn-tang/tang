package com.ooqn.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import io.swagger.v3.oas.annotations.media.Schema;

import com.ooqn.core.BaseController;
import com.ooqn.entity.model.StsNotice;
import com.ooqn.entity.param.StsNoticeParam;
import com.ooqn.service.StsNoticeService;
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

@RestController
@RequestMapping("api/admin/notice")
@Schema(name = "公告管理")
public class AdminNoticeController extends BaseController {

	@Autowired
	private StsNoticeService noticeService;

	@PostMapping
	public StsNotice insert(@RequestBody StsNoticeParam noticeParam) {
		StsNotice notice = BeanUtil.toBean(noticeParam, StsNotice.class);
		notice.setCreateTime(DateUtil.date());
		return noticeService.insertNotice(notice);
	}

	@PutMapping
	public StsNotice update(@RequestBody StsNoticeParam noticeParam) {
		StsNotice notice = BeanUtil.toBean(noticeParam, StsNotice.class);
		return noticeService.updateNotice(notice);
	}

	@PutMapping("order")
	public void updateOrder(@RequestBody StsNoticeParam[] noticeList) {
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
