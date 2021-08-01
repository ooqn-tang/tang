package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsBlogSubjectDto;
import net.ttcxy.tang.portal.entity.model.DtsBlogSubject;
import net.ttcxy.tang.portal.entity.param.DtsSubjectParam;
import net.ttcxy.tang.portal.service.DtsBlogSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subject")
@Validated
public class ApiBlogSubjectController {

    @Autowired
    private DtsBlogSubjectService blogSubjectService;


    @GetMapping("username")
    public ResponseResult<PageInfo<DtsBlogSubjectDto>> selectSubjectBlogListByUsername(
            @RequestParam(value = "username",defaultValue = "0")String username){

        PageInfo<DtsBlogSubjectDto> subjectDtoPageInfo =
                blogSubjectService.selectSubjectListByUsername(username, 1, 10);
        return ResponseResult.success(subjectDtoPageInfo);
    }

    @GetMapping("subjectId")
    public ResponseResult<DtsBlogSubjectDto> selectSubjectBlogById(
            @RequestParam(value = "subjectId")String subjectId){

        DtsBlogSubjectDto subjectDto = blogSubjectService.selectSubjectBlogListById(subjectId);
        return ResponseResult.success(subjectDto);
    }


    @GetMapping("list")
    public ResponseResult<PageInfo<DtsBlogSubjectDto>> selectSubject(
            @RequestParam(value = "page",defaultValue = "0")Integer page){

        Integer pageSize = 20;
        PageInfo<DtsBlogSubjectDto> pageInfo = blogSubjectService.selectSubjectList(page,pageSize);
        return ResponseResult.success(pageInfo);
    }

    @GetMapping("search")
    public ResponseResult<PageInfo<DtsBlogSubjectDto>> selectSubjectByName(
            @RequestParam(value = "subjectName",defaultValue = "")String name){

        PageInfo<DtsBlogSubjectDto> pageInfo = blogSubjectService.selectSubjectListBySubjectName(name,1,10);
        return ResponseResult.success(pageInfo);
    }

    @PostMapping
    public ResponseResult<String> insertSubject(@RequestBody DtsSubjectParam subjectParam){

        DtsBlogSubject subjectDto = BeanUtil.toBean(subjectParam, DtsBlogSubject.class);
        String authorId = CurrentUtil.id();
        subjectDto.setAuthorId(authorId);
        Integer count = blogSubjectService.insertSubject(subjectDto);
        if (count > 0){
            return ResponseResult.success("处理成功");
        }
        throw new ApiException();
    }

    @PutMapping
    public ResponseResult<String> updateSubject(@RequestBody DtsSubjectParam subjectParam){

        DtsBlogSubject subject = BeanUtil.toBean(subjectParam, DtsBlogSubject.class);
        Integer count = blogSubjectService.updateSubject(subject);
        if (count > 0){
            return ResponseResult.success("处理成功");
        }
        throw new ApiException();
    }

    @PostMapping("blog")
    public ResponseResult<String> insertBlogToSubject(
            @RequestParam(value = "blogId")String blogId,
            @RequestParam(value = "subjectId")String subjectId){

        Integer count = blogSubjectService.insertBlogToSubject(blogId,subjectId);
        if (count > 0){
            return ResponseResult.success("处理成功");
        }
        throw new ApiException();
    }

    @PutMapping("blog")
    public ResponseResult<String> updateBlogToSubject(
            @RequestParam(value = "blogId")String blogId,
            @RequestParam(value = "subjectId")String subjectId){

        Integer count = blogSubjectService.updateBlogToSubject(blogId,subjectId);
        if (count > 0){
            return ResponseResult.success("处理成功");
        }
        throw new ApiException();
    }

    @GetMapping("blog")
    public ResponseResult<?> selectSubjectListByBlogId(@RequestParam("blogId")String blogId) {
        String subjectId = blogSubjectService.selectSubjectIdByBlogId(blogId);
        return ResponseResult.success(blogSubjectService.selectSubjectBlogListById(subjectId));
    }

}
