package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticleSubject;
import cn.ttcxy.entity.param.DtsSubjectParam;
import cn.ttcxy.service.DtsArticleService;
import cn.ttcxy.service.DtsArticleSubjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subject")
@Validated
public class DtsSubjectController extends BaseController {

    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    @Autowired
    private DtsArticleService articleService;

    @GetMapping("username")
    public PageInfo<DtsArticleSubjectDto> selectSubjectArticleListByUsername(
            @RequestParam(value = "username", defaultValue = "0") String username) {

        return articleSubjectService.selectSubjectListByUsername(username, 1, 10);
    }

    @GetMapping("subjectId")
    public DtsArticleSubjectDto selectSubjectArticleById(
            @RequestParam(value = "subjectId") String subjectId) {

        return articleSubjectService.selectSubjectArticleListById(subjectId);
    }


    @GetMapping("list")
    public PageInfo<DtsArticleSubjectDto> selectSubject(
            @RequestParam(value = "page", defaultValue = "0") Integer page) {

        Integer pageSize = 20;
        return articleSubjectService.selectSubjectList(page, pageSize);
    }

    @GetMapping("search")
    public PageInfo<DtsArticleSubjectDto> selectSubjectByName(
            @RequestParam(value = "subjectName", defaultValue = "") String name) {

        return articleSubjectService.selectSubjectListBySubjectName(name, 1, 10);
    }

    @PostMapping
    public String insertSubject(@RequestBody DtsSubjectParam subjectParam) {

        DtsArticleSubject subjectDto = BeanUtil.toBean(subjectParam, DtsArticleSubject.class);
        String authorId = authorId();
        subjectDto.setAuthorId(authorId);
        Integer count = articleSubjectService.insertSubject(subjectDto);
        if (count > 0) {
            return "处理成功";
        }
        throw new ApiException();
    }

    @PutMapping
    public String updateSubject(@RequestBody DtsSubjectParam subjectParam) {

        DtsArticleSubject subject = BeanUtil.toBean(subjectParam, DtsArticleSubject.class);
        Integer count = articleSubjectService.updateSubject(subject);
        if (count > 0) {
            return "处理成功";
        }
        throw new ApiException();
    }


    @PutMapping("article")
    public String insertArticleToSubject(
            @RequestParam(value = "articleId") String articleId,
            @RequestParam(value = "subjectId") String subjectId) {

        int count = articleService.updateSubject(articleId,subjectId);
        if (count > 0) {
            return "处理成功";
        }
        throw new ApiException();
    }

    @GetMapping("article/{articleId}")
    public DtsArticleSubjectDto selectSubjectListByArticleId(@PathVariable("articleId") String articleId) {
        String subjectId = articleSubjectService.selectSubjectIdByArticleId(articleId);
        return articleSubjectService.selectSubjectArticleListById(subjectId);
    }

}
