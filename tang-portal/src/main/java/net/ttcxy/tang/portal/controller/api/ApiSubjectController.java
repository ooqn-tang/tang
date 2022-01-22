package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsArticleSubjectDto;
import net.ttcxy.tang.portal.entity.model.DtsArticleSubject;
import net.ttcxy.tang.portal.entity.param.DtsSubjectParam;
import net.ttcxy.tang.portal.service.DtsArticleSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subject")
@Validated
public class ApiSubjectController {

    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    @GetMapping("username")
    public ResponseEntity<PageInfo<DtsArticleSubjectDto>> selectSubjectArticleListByUsername(
            @RequestParam(value = "username", defaultValue = "0") String username) {

        PageInfo<DtsArticleSubjectDto> subjectDtoPageInfo =
                articleSubjectService.selectSubjectListByUsername(username, 1, 10);
        return ResponseEntity.ok(subjectDtoPageInfo);
    }

    @GetMapping("subjectId")
    public ResponseEntity<DtsArticleSubjectDto> selectSubjectArticleById(
            @RequestParam(value = "subjectId") String subjectId) {

        DtsArticleSubjectDto subjectDto = articleSubjectService.selectSubjectArticleListById(subjectId);
        return ResponseEntity.ok(subjectDto);
    }


    @GetMapping("list")
    public ResponseEntity<PageInfo<DtsArticleSubjectDto>> selectSubject(
            @RequestParam(value = "page", defaultValue = "0") Integer page) {

        Integer pageSize = 20;
        PageInfo<DtsArticleSubjectDto> pageInfo = articleSubjectService.selectSubjectList(page, pageSize);
        return ResponseEntity.ok(pageInfo);
    }

    @GetMapping("search")
    public ResponseEntity<PageInfo<DtsArticleSubjectDto>> selectSubjectByName(
            @RequestParam(value = "subjectName", defaultValue = "") String name) {

        PageInfo<DtsArticleSubjectDto> pageInfo = articleSubjectService.selectSubjectListBySubjectName(name, 1, 10);
        return ResponseEntity.ok(pageInfo);
    }

    @PostMapping
    public ResponseEntity<String> insertSubject(@RequestBody DtsSubjectParam subjectParam) {

        DtsArticleSubject subjectDto = BeanUtil.toBean(subjectParam, DtsArticleSubject.class);
        String authorId = CurrentUtil.id();
        subjectDto.setAuthorId(authorId);
        Integer count = articleSubjectService.insertSubject(subjectDto);
        if (count > 0) {
            return ResponseEntity.ok("处理成功");
        }
        throw new ApiException(ResponseCode.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<String> updateSubject(@RequestBody DtsSubjectParam subjectParam) {

        DtsArticleSubject subject = BeanUtil.toBean(subjectParam, DtsArticleSubject.class);
        Integer count = articleSubjectService.updateSubject(subject);
        if (count > 0) {
            return ResponseEntity.ok("处理成功");
        }
        throw new ApiException(ResponseCode.ACCEPTED);
    }

    @PostMapping("article")
    public ResponseEntity<String> insertArticleToSubject(
            @RequestParam(value = "articleId") String articleId,
            @RequestParam(value = "subjectId") String subjectId) {

        Integer count = articleSubjectService.insertArticleToSubject(articleId, subjectId);
        if (count > 0) {
            return ResponseEntity.ok("处理成功");
        }
        throw new ApiException(ResponseCode.ACCEPTED);
    }

    @PutMapping("article")
    public ResponseEntity<String> updateArticleToSubject(
            @RequestParam(value = "articleId") String articleId,
            @RequestParam(value = "subjectId") String subjectId) {

        Integer count = articleSubjectService.updateArticleToSubject(articleId, subjectId);
        if (count > 0) {
            return ResponseEntity.ok("处理成功");
        }
        throw new ApiException(ResponseCode.ACCEPTED);
    }

    @GetMapping("article/{articleId}")
    public ResponseEntity<DtsArticleSubjectDto> selectSubjectListByArticleId(@PathVariable("articleId") String articleId) {
        String subjectId = articleSubjectService.selectSubjectIdByArticleId(articleId);
        return ResponseEntity.ok(articleSubjectService.selectSubjectArticleListById(subjectId));
    }

}
