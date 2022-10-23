package cn.ttcxy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.core.exception.ApiException;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleSubject;
import cn.ttcxy.entity.model.DtsArticleSubjectRelevance;
import cn.ttcxy.entity.param.DtsSubjectParam;
import cn.ttcxy.service.DtsArticleService;
import cn.ttcxy.service.DtsArticleSubjectService;

@RestController
@RequestMapping("api/subject")
@Validated
public class DtsSubjectController extends BaseController {

    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    @Autowired
    private DtsArticleService articleService;

    @GetMapping("username")
    public List<DtsArticleSubjectDto> selectSubjectArticleListByUsername(@RequestParam(value = "username", defaultValue = "0") String username) {
        return articleSubjectService.selectSubjectListByUsername(username);
    }

    @GetMapping("id/{subjectId}")
    public DtsArticleSubjectDto selectSubjectArticleById(@PathVariable(value = "subjectId") String subjectId) {
        return articleSubjectService.findSubjectArticleListBySubjectId(subjectId);
    }

    @GetMapping("list")
    public Page<DtsArticleSubjectDto> selectSubject( @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 20);
        return articleSubjectService.selectSubjectList(pageable);
    }

    @GetMapping("search")
    public Page<DtsArticleSubjectDto> selectSubjectByName(@RequestParam(value = "subjectName", defaultValue = "") String name) {
        Pageable pageable = PageRequest.of(1, 15);
        return articleSubjectService.selectSubjectListBySubjectName(name, pageable);
    }

    @PostMapping
    public String insertSubject(@RequestBody DtsSubjectParam subjectParam) {
        DtsArticleSubject subjectDto = BeanUtil.toBean(subjectParam, DtsArticleSubject.class);
        String authorId = authorId();
        subjectDto.setAuthorId(authorId);
        DtsArticleSubject dtsArticleSubject = articleSubjectService.insertSubject(subjectDto);
        if (dtsArticleSubject != null) {
            return "处理成功";
        }
        throw new ApiException();
    }

    @PutMapping
    public String updateSubject(@RequestBody DtsSubjectParam subjectParam) {
        DtsArticleSubject subject = BeanUtil.toBean(subjectParam, DtsArticleSubject.class);
        subject = articleSubjectService.updateSubject(subject);
        if (subject != null) {
            return "处理成功";
        }
        throw new ApiException();
    }

    @PutMapping("article")
    public DtsArticleSubjectRelevance insertArticleToSubject(@RequestParam(value = "articleId") String articleId, @RequestParam(value = "subjectId") String subjectId) {
        return articleService.saveSubjectId(articleId, subjectId);
        
    }

    @GetMapping("article/{articleId}")
    public List<DtsArticle> findSubjectListByArticleId(@PathVariable("articleId") String articleId) {
        return articleSubjectService.findSubjectArticleTitleListByArticleId(articleId);
    }

}
