package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogSubjectDto;
import net.ttcxy.tang.gateway.entity.model.DtsBlogSubject;
import net.ttcxy.tang.gateway.entity.param.DtsSubjectParam;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.DtsBlogSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api("博客专题")
@RestController
@RequestMapping("subject")
@Validated
public class DtsBlogSubjectController {

    @Autowired
    private DtsBlogSubjectService blogSubjectService;

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @GetMapping("username")
    @ApiOperation("通过用户名查询专题博客列表")
    public ResponseResult<PageInfo<DtsBlogSubjectDto>> selectSubjectBlogListByUsername(
            @RequestParam(value = "username",defaultValue = "0")String username){

        PageInfo<DtsBlogSubjectDto> subjectDtoPageInfo =
                blogSubjectService.selectSubjectListByUsername(username, 1, 10);
        return ResponseResult.success(subjectDtoPageInfo);
    }

    @GetMapping("subjectId")
    @ApiOperation("通过专辑ID查询专辑所有博客")
    public ResponseResult<DtsBlogSubjectDto> selectSubjectBlogById(
            @PathVariable(value = "subjectId")String subjectId){

        DtsBlogSubjectDto subjectDto = blogSubjectService.selectSubjectBlogListById(subjectId);
        return ResponseResult.success(subjectDto);
    }


    @GetMapping("list")
    @ApiOperation("查询专题列表")
    public ResponseResult<PageInfo<DtsBlogSubjectDto>> selectSubject(
            @RequestParam(value = "page",defaultValue = "0")Integer page){

        Integer pageSize = 20;
        PageInfo<DtsBlogSubjectDto> pageInfo = blogSubjectService.selectSubjectList(page,pageSize);
        return ResponseResult.success(pageInfo);
    }

    @GetMapping("search")
    @ApiOperation("通过专题名模糊查询")
    public ResponseResult<PageInfo<DtsBlogSubjectDto>> selectSubjectByName(
            @RequestParam(value = "subjectName",defaultValue = "")String name){

        PageInfo<DtsBlogSubjectDto> pageInfo = blogSubjectService.selectSubjectListByUsername(name,10,10);
        return ResponseResult.success(pageInfo);
    }

    @PostMapping
    @ApiOperation("添加专题")
    public ResponseResult<String> insertSubject(@RequestBody DtsSubjectParam subjectParam){

        DtsBlogSubject subjectDto = BeanUtil.toBean(subjectParam, DtsBlogSubject.class);
        String authorId = currentAuthorService.getAuthorId();
        subjectDto.setAuthorId(authorId);
        Integer count = blogSubjectService.insertSubject(subjectDto);
        if (count > 0){
            return ResponseResult.success();
        }
        throw new ApiException();
    }

    @PutMapping
    @ApiOperation("修改专题")
    public ResponseResult<String> updateSubject(@RequestBody DtsSubjectParam subjectParam){

        DtsBlogSubject subject = BeanUtil.toBean(subjectParam, DtsBlogSubject.class);
        Integer count = blogSubjectService.updateSubject(subject);
        if (count > 0){
            return ResponseResult.success();
        }
        throw new ApiException();
    }

    @PostMapping("blog")
    @ApiOperation("添加博客到专题")
    public ResponseResult<String> insertBlogToSubject(
            @RequestParam(value = "blogId")String blogId,
            @RequestParam(value = "subjectId")String subjectId){

        Integer count = blogSubjectService.insertBlogToSubject(blogId,subjectId);
        if (count > 0){
            return ResponseResult.success();
        }
        throw new ApiException();
    }

    @GetMapping("blog")
    @ApiOperation("通过博客ID查询当前专辑列表")
    public ResponseResult<?> selectSubjectListByBlogId(@RequestParam("blogId")String blogId) {
        String subjectId = blogSubjectService.selectSubjectIdByBlogId(blogId);
        return ResponseResult.success(blogSubjectService.selectSubjectBlogListById(subjectId));
    }

}
