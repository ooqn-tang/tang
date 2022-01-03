package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsArticleTagDto;
import net.ttcxy.tang.portal.entity.model.DtsArticleTag;
import net.ttcxy.tang.portal.entity.param.DtsTagParam;
import net.ttcxy.tang.portal.service.DtsArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tag")
@Validated
public class ApiArticleTagController {

    @Autowired
    private DtsArticleTagService articleTagService;

    @GetMapping
    public ResponseResult<DtsArticleTagDto> selectTagArticleListByUsername(
            @RequestParam(value = "tagId", defaultValue = "0") String tagId,
            @RequestParam(value = "username", defaultValue = "0") String username) {

        DtsArticleTagDto tagDto = articleTagService.selectTagArticleCountListByUsername(tagId, username);
        return ResponseResult.success(tagDto);
    }

    @GetMapping("allTag")
    public ResponseResult<List<DtsArticleTagDto>> selectAllTag() {
        List<DtsArticleTagDto> list = articleTagService.selectAuthorAllTag();
        return ResponseResult.success(list);
    }

    @PostMapping("author")
    public ResponseResult<Integer> insertAuthorTag(@RequestParam(value = "tagId") String tagId) {
        String authorId = CurrentUtil.id();
        Integer count = articleTagService.insertAuthorTag(authorId, tagId);
        return ResponseResult.success(count);
    }

    @GetMapping("search")
    public ResponseResult<PageInfo<DtsArticleTagDto>> selectTagByName(
            @RequestParam(value = "tagName", defaultValue = "") String name) {
        PageInfo<DtsArticleTagDto> pageInfo = articleTagService.selectTagListByName(name, 1, 10);
        return ResponseResult.success(pageInfo);
    }


    @GetMapping("list")
    public ResponseResult<PageInfo<DtsArticleTagDto>> selectTag(
            @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Integer pageSize = 20;
        PageInfo<DtsArticleTagDto> pageInfo = articleTagService.selectTagList(page, pageSize);
        return ResponseResult.success(pageInfo);
    }


    @PostMapping
    public ResponseResult<String> insertTag(@RequestBody DtsTagParam tagParam) {
        DtsArticleTag tagDto = BeanUtil.toBean(tagParam, DtsArticleTag.class);
        String tagId = articleTagService.insertTag(tagDto);
        return ResponseResult.success(tagId);
    }

    @PutMapping
    public ResponseResult<String> updateTag(DtsTagParam tagParam) {
        DtsArticleTag tag = BeanUtil.toBean(tagParam, DtsArticleTag.class);
        Integer count = articleTagService.updateTag(tag);
        if (count > 0) {
            return ResponseResult.success("操作成功");
        }
        throw new ApiException();
    }

}
