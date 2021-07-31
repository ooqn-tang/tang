package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsBlogTagDto;
import net.ttcxy.tang.portal.entity.model.DtsBlogTag;
import net.ttcxy.tang.portal.entity.param.DtsTagParam;
import net.ttcxy.tang.portal.service.DtsBlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tag")
@Validated
public class ApiBlogTagController {

    @Autowired
    private DtsBlogTagService blogTagService;

    @GetMapping
    public ResponseResult<DtsBlogTagDto> selectTagBlogListByUsername(
            @RequestParam(value = "tagId",defaultValue = "0")String tagId,
            @RequestParam(value = "username",defaultValue = "0")String username){

        DtsBlogTagDto tagDto = blogTagService.selectTagBlogCountListByUsername(tagId,username);
        return ResponseResult.success(tagDto);
    }

    @GetMapping("allTag")
    public ResponseResult<List<DtsBlogTagDto>> selectAllTag(){
        List<DtsBlogTagDto> list = blogTagService.selectAuthorAllTag();
        return ResponseResult.success(list);
    }

    @PostMapping("author")
    public ResponseResult<?> insertAuthorTag(@RequestParam(value = "tagId") String tagId){
        String authorId = CurrentUtil.id();
        Integer count = blogTagService.insertAuthorTag(authorId,tagId);
        return ResponseResult.success(count);
    }

    @GetMapping("search")
    public ResponseResult<PageInfo<DtsBlogTagDto>> selectTagByName(
            @RequestParam(value = "tagName",defaultValue = "")String name){
        PageInfo<DtsBlogTagDto> pageInfo = blogTagService.selectTagListByName(name,1,10);
        return ResponseResult.success(pageInfo);
    }



    @GetMapping("list")
    public ResponseResult<PageInfo<DtsBlogTagDto>> selectTag(
            @RequestParam(value = "page",defaultValue = "0")Integer page){
        Integer pageSize = 20;
        PageInfo<DtsBlogTagDto> pageInfo = blogTagService.selectTagList(page,pageSize);
        return ResponseResult.success(pageInfo);
    }


    @PostMapping
    public ResponseResult<String> insertTag(@RequestBody DtsTagParam tagParam){
        DtsBlogTag tagDto = BeanUtil.toBean(tagParam, DtsBlogTag.class);
        String tagId = blogTagService.insertTag(tagDto);
        return ResponseResult.success(tagId);
    }

    @PutMapping
    public ResponseResult<String> updateTag(DtsTagParam tagParam){
        DtsBlogTag tag = BeanUtil.toBean(tagParam, DtsBlogTag.class);
        Integer count = blogTagService.updateTag(tag);
        if (count > 0){
            return ResponseResult.success("操作成功");
        }
        throw new ApiException();
    }

}
