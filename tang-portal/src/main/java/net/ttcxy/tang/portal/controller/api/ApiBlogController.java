package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import net.ttcxy.tang.portal.entity.dto.DtsBlogDto;
import net.ttcxy.tang.portal.entity.model.DtsBlog;
import net.ttcxy.tang.portal.entity.param.DtsBlogParam;
import net.ttcxy.tang.portal.service.DtsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class ApiBlogController {

    @Autowired
    private DtsBlogService blogService;

    @GetMapping("search")
    public ResponseResult<?> searchBlogList(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "title" ,defaultValue = "")String title){
        PageInfo<DtsBlogDto> blogList = blogService.search(title, page, 10);
        return ResponseResult.success(blogList);
    }

    @GetMapping("list")
    public ResponseResult<?> selectBlogList(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "tag",defaultValue = "")String tagName){
        PageInfo<DtsBlogDto> blogList = blogService.selectBlogList(tagName,page, 10);
        return ResponseResult.success(blogList);
    }

    @GetMapping("list/{username}")
    public ResponseResult<?> selectBlogListByUsername(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @PathVariable(value = "username")String username){
        PageInfo<DtsBlogDto> blogList = blogService.selectBlogByAuthorName(username, page, 10);
        return ResponseResult.success(blogList);
    }

    @GetMapping("recommend")
    public ResponseResult<?> selectBlogListRecommend(){
        return ResponseResult.success(blogService.selectBlogListRandom());
    }

    @DeleteMapping("{blogId}")
    public ResponseResult<?> delete(@PathVariable("blogId") String blogId){
        DtsBlog blog = blogService.selectByPrimaryId(blogId);
        if (blog == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        String blogAuthorId = blog.getAuthorId();
        String currentAuthorId = CurrentUtil.id();
        int count = 0;

        if(StrUtil.equals(currentAuthorId,blogAuthorId)){
            count = blogService.deleteBlog(blogId);
            if(count > 0){
                return ResponseResult.success("处理成功");
            }
        }else{
            throw new ApiException("不能删除别入的文章");
        }

        throw new ApiException(ResponseCode.FAILED);

    }

    @PostMapping
    public ResponseResult<?> create(){
        DtsBlog blog = new DtsBlog();
        blog.setBlogId(IdUtil.objectId());
        DateTime dateTime = new DateTime();
        blog.setCreateDate(dateTime);
        blog.setUpdateDate(dateTime);
        blog.setStateCode(1005);
        String authorId = CurrentUtil.id();
        blog.setAuthorId(authorId);
        if (blogService.insertBlog(blog) > 0){
            return ResponseResult.success(blog.getBlogId());
        }
        throw new ApiException("创建失败");

    }

    @PutMapping
    public ResponseResult<?> update(@RequestBody @Validated DtsBlogParam blogParam){
        DtsBlog blog = BeanUtil.toBean(blogParam, DtsBlog.class);
        blog.setStateCode(1001);

        List<String> tagIdList = blogParam.getTagIdList();
        String subjectId = blogParam.getSubjectId();
        // 当前博客信息
        DtsBlogDto blogDto = blogService.selectBlogById(blog.getBlogId());
        if (blogDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        String thisBlogUsername = blogDto.getUsername();

        String username = CurrentUtil.name();
        if (StrUtil.equals(username,thisBlogUsername)){
            DateTime date = DateUtil.date();
            blog.setUpdateDate(date);
            int count = blogService.updateBlog(blog,subjectId,tagIdList);
            if (count > 0){
                return ResponseResult.success(blog.getBlogId());
            }
        }
        throw new ApiException(ResponseCode.FORBIDDEN);
    }

    @GetMapping("load")
    public ResponseResult<?> load(@RequestParam(name="blogId") String blogId){
        DtsBlogDto blogDto = blogService.selectBlogById(blogId);
        if (blogDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        return ResponseResult.success(blogDto);
    }

    @GetMapping("load/all")
    public ResponseResult<?> loadAll(@RequestParam(name = "blogId") String blogId){
        DtsBlogDto blogDto = blogService.selectBlogAllById(blogId);
        if (blogDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        return ResponseResult.success(blogDto);
    }

    @GetMapping("like")
    public ResponseResult<?> getLike(@RequestParam("blogId") String blogId){
        String authorId = CurrentUtil.id();;
        return ResponseResult.success(blogService.selectLike(authorId,blogId));
    }

    @GetMapping("like/list")
    public ResponseResult<PageInfo<DtsBlogDto>> listLike(
            @RequestParam(value = "page",defaultValue = "1") Integer page){
        String username = CurrentUtil.author().getUsername();
        return ResponseResult.success(blogService.selectLikeBlogList(username, page, 10));
    }

    @PostMapping("like")
    public ResponseResult<?> postLike(@RequestParam("blogId") String blogId){
        String authorId = CurrentUtil.id();
        return ResponseResult.success(blogService.like(authorId,blogId));
    }

    @DeleteMapping("like")
    public ResponseResult<?> deleteLike(@RequestParam("blogId") String blogId){
        String authorId = CurrentUtil.id();
        return ResponseResult.success(blogService.unlike(authorId,blogId));
    }


}
