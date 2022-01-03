package net.ttcxy.tang.portal.controller.api;

import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.entity.model.DtsNotice;
import net.ttcxy.tang.portal.service.StsNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/notice")
public class ApiNoticeController {

    @Autowired
    private StsNoticeService noticeService;

    @GetMapping("list")
    public ResponseResult<List<DtsNotice>> loadAdv() {
        return ResponseResult.success(noticeService.selectAllNotice());
    }
}
