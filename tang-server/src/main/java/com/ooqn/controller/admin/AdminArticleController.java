package com.ooqn.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.entity.dto.DtsArticleDto;
import com.ooqn.service.DtsArticleSubjectService;

import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("api/admin/article")
@Schema(name = "文章管理")
public class AdminArticleController {

    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    @GetMapping
    public Page<DtsArticleDto> find(
            @RequestParam(value = "state", defaultValue = "1") Integer state,
            @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return articleSubjectService.findArticleList(state,pageable);
       
    }

    @DeleteMapping("{articleId}")
    public void delete(
            @PathVariable("articleId")String articleId) {
        articleSubjectService.deleteArticleByArticleId(articleId);
    }

    @PutMapping
    public Page<DtsArticleDto> update() {
        return null;
    }
}
