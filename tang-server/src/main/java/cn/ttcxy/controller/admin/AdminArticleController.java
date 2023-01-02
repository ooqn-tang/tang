package cn.ttcxy.controller.admin;

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

import cn.ttcxy.entity.dto.DtsArticleDto;
import cn.ttcxy.service.DtsArticleSubjectService;

@RestController
@RequestMapping("api/admin/article")
public class AdminArticleController {

    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    @GetMapping
    public Page<DtsArticleDto> find(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "state", defaultValue = "1") Integer state) {
        Pageable pageable = PageRequest.of(page, 10);
        return articleSubjectService.findArticleList(pageable,state);
       
    }

    @DeleteMapping("{articleId}")
    public void delete(@PathVariable("articleId")String articleId) {
        articleSubjectService.deleteArticleByArticleId(articleId);
    }

    @PutMapping
    public Page<DtsArticleDto> update() {
        return null;
    }
}
