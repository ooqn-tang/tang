package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogTagDto;
import net.ttcxy.tang.gateway.entity.model.DtsBlogTag;
import net.ttcxy.tang.gateway.entity.param.DtsTagParam;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.DtsBlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api("博客标签")
@RestController
@RequestMapping("tag")
@Validated
public class DtsBlogTagController {

    @Autowired
    private DtsBlogTagService blogTagService;

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @GetMapping
    @ApiOperation("通过用户名查询标签博客列表")
    public ResponseResult<DtsBlogTagDto> selectTagBlogListByUsername(
            @RequestParam(value = "tagId",defaultValue = "0")String tagId,
            @RequestParam(value = "username",defaultValue = "0")String username){

        DtsBlogTagDto tagDto = blogTagService.selectTagBlogListByUsername(tagId,username);
        return ResponseResult.success(tagDto);
    }


    @GetMapping("list")
    @ApiOperation("查询标签列表")
    public ResponseResult<PageInfo<DtsBlogTagDto>> selectTag(
            @RequestParam(value = "page",defaultValue = "0")Integer page){
        Integer pageSize = 20;
        PageInfo<DtsBlogTagDto> pageInfo = blogTagService.selectTagList(page,pageSize);
        return ResponseResult.success(pageInfo);
    }


    @PostMapping
    @ApiOperation("添加标签")
    public ResponseResult<String> insertTag(DtsTagParam tagParam){
        DtsBlogTag tagDto = BeanUtil.toBean(tagParam, DtsBlogTag.class);
        Integer count = blogTagService.insertTag(tagDto);
        if (count > 0){
            return ResponseResult.success();
        }
        throw new ApiException();
    }

    @PutMapping
    @ApiOperation("修改标签")
    public ResponseResult<String> updateTag(DtsTagParam tagParam){
        DtsBlogTag tag = BeanUtil.toBean(tagParam, DtsBlogTag.class);
        Integer count = blogTagService.updateTag(tag);
        if (count > 0){
            return ResponseResult.success();
        }
        throw new ApiException();
    }

}
