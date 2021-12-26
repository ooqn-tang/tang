package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsArticleSubjectDto;
import net.ttcxy.tang.portal.entity.model.DtsArticleSubject;
import net.ttcxy.tang.portal.entity.param.DtsSubjectParam;
import net.ttcxy.tang.portal.service.DtsArticleSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subject")
@Validated
public class ApiArticleSubjectController {

    @Autowired
    private DtsArticleSubjectService articleSubjectService;

    @GetMapping("username")
    public ResponseResult<PageInfo<DtsArticleSubjectDto>> selectSubjectArticleListByUsername(
            @RequestParam(value = "username",defaultValue = "0")String username){

        PageInfo<DtsArticleSubjectDto> subjectDtoPageInfo =
                articleSubjectService.selectSubjectListByUsername(username, 1, 10);
        return ResponseResult.success(subjectDtoPageInfo);
    }

    @GetMapping("subjectId")
    public ResponseResult<DtsArticleSubjectDto> selectSubjectArticleById(
            @RequestParam(value = "subjectId")String subjectId){

        DtsArticleSubjectDto subjectDto = articleSubjectService.selectSubjectArticleListById(subjectId);
        return ResponseResult.success(subjectDto);
    }


    @GetMapping("list")
    public ResponseResult<PageInfo<DtsArticleSubjectDto>> selectSubject(
            @RequestParam(value = "page",defaultValue = "0")Integer page){

        Integer pageSize = 20;
        PageInfo<DtsArticleSubjectDto> pageInfo = articleSubjectService.selectSubjectList(page,pageSize);
        return ResponseResult.success(pageInfo);
    }

    @GetMapping("search")
    public ResponseResult<PageInfo<DtsArticleSubjectDto>> selectSubjectByName(
            @RequestParam(value = "subjectName",defaultValue = "")String name){

        PageInfo<DtsArticleSubjectDto> pageInfo = articleSubjectService.selectSubjectListBySubjectName(name,1,10);
        return ResponseResult.success(pageInfo);
    }

    @PostMapping
    public ResponseResult<String> insertSubject(@RequestBody DtsSubjectParam subjectParam){

        DtsArticleSubject subjectDto = BeanUtil.toBean(subjectParam, DtsArticleSubject.class);
        String authorId = CurrentUtil.id();
        subjectDto.setAuthorId(authorId);
        Integer count = articleSubjectService.insertSubject(subjectDto);
        if (count > 0){
            return ResponseResult.success("处理成功");
        }
        throw new ApiException();
    }

    @PutMapping
    public ResponseResult<String> updateSubject(@RequestBody DtsSubjectParam subjectParam){

        DtsArticleSubject subject = BeanUtil.toBean(subjectParam, DtsArticleSubject.class);
        Integer count = articleSubjectService.updateSubject(subject);
        if (count > 0){
            return ResponseResult.success("处理成功");
        }
        throw new ApiException();
    }

    @PostMapping("article")
    public ResponseResult<String> insertArticleToSubject(
            @RequestParam(value = "articleId")String articleId,
            @RequestParam(value = "subjectId")String subjectId){

        Integer count = articleSubjectService.insertArticleToSubject(articleId,subjectId);
        if (count > 0){
            return ResponseResult.success("处理成功");
        }
        throw new ApiException();
    }

    @PutMapping("article")
    public ResponseResult<String> updateArticleToSubject(
            @RequestParam(value = "articleId")String articleId,
            @RequestParam(value = "subjectId")String subjectId){

        Integer count = articleSubjectService.updateArticleToSubject(articleId,subjectId);
        if (count > 0){
            return ResponseResult.success("处理成功");
        }
        throw new ApiException();
    }

    @GetMapping("article")
    public ResponseResult<DtsArticleSubjectDto> selectSubjectListByArticleId(@RequestParam("articleId")String articleId) {
        String subjectId = articleSubjectService.selectSubjectIdByArticleId(articleId);
        return ResponseResult.success(articleSubjectService.selectSubjectArticleListById(subjectId));
    }

}
