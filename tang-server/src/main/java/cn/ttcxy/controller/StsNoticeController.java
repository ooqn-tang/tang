package cn.ttcxy.controller;

import cn.ttcxy.entity.model.StsNotice;
import cn.ttcxy.service.StsNoticeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notice")
public class StsNoticeController extends BaseController {

	@Autowired
	private StsNoticeService noticeService;

	@GetMapping("list")
	public List<StsNotice> select() {
		return noticeService.selectAllNotice();
	}
}
