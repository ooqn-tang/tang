package cn.ttcxy.controller;

import cn.ttcxy.core.BaseController;
import cn.ttcxy.entity.model.StsNotice;
import cn.ttcxy.service.StsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/notice")
public class StsNoticeController extends BaseController {

    @Autowired
    private StsNoticeService noticeService;

    @GetMapping("list")
    public ResponseEntity<List<StsNotice>> select() {
        return ResponseEntity.ok(noticeService.selectAllNotice());
    }
}
