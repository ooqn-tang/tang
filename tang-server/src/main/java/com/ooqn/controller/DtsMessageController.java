package com.ooqn.controller;

import com.ooqn.core.BaseController;
import com.ooqn.entity.dto.DtsMessageDto;
import com.ooqn.service.DtseMssageService;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/message")
@Validated
@Schema(name = "消息")
public class DtsMessageController extends BaseController {

	@Autowired
	private DtseMssageService mssageService;

	@GetMapping
	public List<DtsMessageDto> message() {
		return mssageService.authorMessageList(authorId());
	}
}
