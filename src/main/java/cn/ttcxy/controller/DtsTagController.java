package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.dto.DtsArticleTagDto;
import cn.ttcxy.entity.model.DtsArticleTag;
import cn.ttcxy.entity.param.DtsTagParam;
import cn.ttcxy.service.DtsArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tag")
@Validated
public class DtsTagController extends BaseController {

    @Autowired
    private DtsArticleTagService articleTagService;

    @GetMapping
    public ResponseEntity<DtsArticleTagDto> selectTagArticleListByUsername(
            @RequestParam(value = "tagId", defaultValue = "0") String tagId,
            @RequestParam(value = "username", defaultValue = "0") String username) {

        DtsArticleTagDto tagDto = articleTagService.selectTagArticleCountListByUsername(tagId, username);
        return ResponseEntity.ok(tagDto);
    }

    @GetMapping("all")
    public ResponseEntity<List<DtsArticleTagDto>> selectAllTag() {
        List<DtsArticleTagDto> list = articleTagService.selectAuthorAllTag();
        return ResponseEntity.ok(list);
    }

    @GetMapping("search")
    public ResponseEntity<PageInfo<DtsArticleTagDto>> selectTagByName(@RequestParam(value = "tagName", defaultValue = "") String name) {
        PageInfo<DtsArticleTagDto> pageInfo = articleTagService.selectTagListByName(name, 1, 10);
        return ResponseEntity.ok(pageInfo);
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<DtsArticleTagDto>> selectTag(
            @RequestParam(value = "page", defaultValue = "0") Integer page) {
        Integer pageSize = 20;
        PageInfo<DtsArticleTagDto> pageInfo = articleTagService.selectTagList(page, pageSize);
        return ResponseEntity.ok(pageInfo);
    }


    @PostMapping
    public ResponseEntity<String> insertTag(@RequestBody DtsTagParam tagParam) {
        DtsArticleTag tagDto = BeanUtil.toBean(tagParam, DtsArticleTag.class);
        String tagId = articleTagService.insertTag(tagDto);
        return ResponseEntity.ok(tagId);
    }

    @PutMapping
    public ResponseEntity<String> updateTag(DtsTagParam tagParam) {
        DtsArticleTag tag = BeanUtil.toBean(tagParam, DtsArticleTag.class);
        Integer count = articleTagService.updateTag(tag);
        if (count > 0) {
            return ResponseEntity.ok("操作成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

}
