package cn.ttcxy.controller;

import cn.ttcxy.core.BaseController;
import cn.ttcxy.entity.dto.DtsMessageDto;
import cn.ttcxy.service.DtseMssageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/message")
@Validated
public class DtsMessageController extends BaseController {

    @Autowired
    private DtseMssageService mssageService;

    @GetMapping
    public List<DtsMessageDto> message() {
        return mssageService.authorMessageList(authorId());
    }
}
