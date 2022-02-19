package net.ttcxy.tang.portal.controller;

import net.ttcxy.tang.portal.entity.model.DtsNotice;
import net.ttcxy.tang.portal.service.StsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/notice")
public class StsNoticeController {

    @Autowired
    private StsNoticeService noticeService;

    @GetMapping("list")
    public ResponseEntity<List<DtsNotice>> loadAdv() {
        return ResponseEntity.ok(noticeService.selectAllNotice());
    }
}
