package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogSubjectDto;
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

    @GetMapping
    @ApiOperation("查询专题列表")
    public ResponseResult<DtsBlogSubjectDto> selectSubject(
            @RequestParam(value = "subjectId",defaultValue = "0")String subjectId){

        DtsBlogSubjectDto blogSubjectDto = blogSubjectService.selectSubjectAllInfo(subjectId);
        return ResponseResult.success(blogSubjectDto);
    }

    @GetMapping("list")
    @ApiOperation("查询专题列表")
    public ResponseResult<PageInfo<DtsBlogSubjectDto>> selectSubject(
            @RequestParam(value = "page",defaultValue = "0")Integer page,
            @RequestParam(value = "name",defaultValue = "")String name){
        Integer pageSize = 20;
        PageInfo<DtsBlogSubjectDto> pageInfo = blogSubjectService.selectSubjectList(page,pageSize,name);
        return ResponseResult.success(pageInfo);
    }


    @PostMapping
    @ApiOperation("添加专题")
    public ResponseResult<String> insertSubject(DtsSubjectParam subjectParam){
        DtsBlogSubjectDto subjectDto = BeanUtil.toBean(subjectParam, DtsBlogSubjectDto.class);
        Integer count = blogSubjectService.insertSubject(subjectDto);
        if (count > 0){
            return ResponseResult.success();
        }
        throw new ApiException();
    }

    @DeleteMapping
    @ApiOperation("删除专题")
    public ResponseResult<String> deleteSubject(String subjectId){


        String authorId = currentAuthorService.getAuthorId();

        DtsBlogSubjectDto subjectDto = blogSubjectService.selectSubjectInfo(subjectId);

        Integer count = blogSubjectService.deleteSubject(subjectId);




        if (count > 0){
            return ResponseResult.success();
        }
        throw new ApiException();
    }

    @PutMapping
    @ApiOperation("修改专题")
    public ResponseResult<String> updateSubject(DtsSubjectParam subjectParam){
        DtsBlogSubjectDto subjectDto = BeanUtil.toBean(subjectParam, DtsBlogSubjectDto.class);
        Integer count = blogSubjectService.updateSubject(subjectDto);
        if (count > 0){
            return ResponseResult.success();
        }
        throw new ApiException();
    }

}
