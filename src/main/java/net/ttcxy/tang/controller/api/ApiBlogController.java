package net.ttcxy.tang.controller.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.core.api.ApiException;
import net.ttcxy.tang.core.api.ResponseCode;
import net.ttcxy.tang.core.api.ResponseResult;
import net.ttcxy.tang.entity.dto.DtsBlogDto;
import net.ttcxy.tang.entity.model.DtsBlog;
import net.ttcxy.tang.entity.model.UtsAuthor;
import net.ttcxy.tang.entity.param.DtsBlogParam;
import net.ttcxy.tang.service.CurrentAuthorService;
import net.ttcxy.tang.service.DtsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/blog")
@Api("博客")
public class ApiBlogController {

    @Autowired
    private DtsBlogService blogService;

    @Autowired
    private CurrentAuthorService currentAuthor;

    @GetMapping("search")
    @ApiOperation("搜索数据")
    public ResponseResult<?> searchBlogList(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "title" ,defaultValue = "")String title){
        PageInfo<DtsBlogDto> blogList = blogService.search(title, page, 10);
        return ResponseResult.success(blogList);
    }

    @GetMapping("list")
    @ApiOperation("获取首页数据")
    public ResponseResult<?> selectBlogList(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "tag",defaultValue = "")String tagName){
        PageInfo<DtsBlogDto> blogList = blogService.selectBlogList(tagName,page, 10);
        return ResponseResult.success(blogList);
    }

    @GetMapping("list/{username}")
    @ApiOperation("用户名获取首页数据")
    public ResponseResult<?> selectBlogListByUsername(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @PathVariable(value = "username")String username){
        PageInfo<DtsBlogDto> blogList = blogService.selectBlogByAuthorName(username, page, 10);
        return ResponseResult.success(blogList);
    }

    @GetMapping("recommend")
    @ApiOperation("获取推荐")
    public ResponseResult<?> selectBlogListRecommend(){
        return ResponseResult.success(blogService.selectBlogListRandom());
    }

    @DeleteMapping("{blogId}")
    @ApiOperation("删除博客")
    public ResponseResult<?> delete(@PathVariable("blogId") String blogId){
        DtsBlog blog = blogService.selectByPrimaryId(blogId);
        if (blog == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        String blogAuthorId = blog.getAuthorId();
        String currentAuthorId = currentAuthor.getAuthorId();
        int count = 0;

        if(StrUtil.equals(currentAuthorId,blogAuthorId)){
            count = blogService.deleteBlog(blogId);
            if(count > 0){
                return ResponseResult.success();
            }
        }else{
            throw new ApiException("不能删除别入的文章");
        }

        throw new ApiException(ResponseCode.FAILED);

    }

    @PutMapping
    @ApiOperation("更新博客")
    public ResponseResult<?> update(@RequestBody @Validated DtsBlogParam blogParam){
        DtsBlog blog = BeanUtil.toBean(blogParam, DtsBlog.class);
        // 当前博客信息
        DtsBlogDto blogDto = blogService.selectBlogById(blog.getBlogId());
        if (blogDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        String thisBlogUsername = blogDto.getUsername();

        String username = currentAuthor.getAuthor().getUsername();
        if (StrUtil.equals(username,thisBlogUsername)){
            DateTime date = DateUtil.date();
            blog.setUpdateDate(date);
            int count = blogService.updateBlog(blog);
            if (count > 0){
                return ResponseResult.success();
            }
        }
        throw new ApiException(ResponseCode.FORBIDDEN);
    }

    @PostMapping
    @ApiOperation("添加博客")
    public ResponseResult<?> insert(@RequestBody @Validated DtsBlogParam blogParam){
        DtsBlog blog = BeanUtil.toBean(blogParam, DtsBlog.class);
        List<String> tagIdList = blogParam.getTagIdList();
        if (blogService.insertBlog(blog , blogParam.getSubjectId() , tagIdList) > 0){
            Map<String,String> map = new HashMap<>();
            map.put("blogId",blog.getBlogId());
            map.put("username",currentAuthor.getAuthor().getUsername());
            return ResponseResult.success(map);
        }
        return ResponseResult.failed("添加失败");

    }

    @GetMapping("load")
    @ApiOperation("通过ID加载博客HTML信息")
    public ResponseResult<?> load(@RequestParam(name="blogId") String blogId){
        DtsBlogDto blogDto = blogService.selectBlogById(blogId);
        if (blogDto == null){
            throw new ApiException(ResponseCode.FAILED);
        }
        return ResponseResult.success(blogDto);
    }

    @GetMapping("like")
    @ApiOperation("查询喜欢")
    public ResponseResult<?> getLike(@RequestParam("blogId") String blogId){
        UtsAuthor author = currentAuthor.getAuthor();
        return ResponseResult.success(blogService.selectLike(author.getAuthorId(),blogId));
    }

    @GetMapping("like/list")
    @ApiOperation("用户名获取喜欢的文章")
    public ResponseResult<PageInfo<DtsBlogDto>> listLike(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "page",defaultValue = "1") Integer page){
        return ResponseResult.success(blogService.selectLikeBlogList(username, page, 10));
    }

    @PostMapping("like")
    @ApiOperation("添加喜欢")
    public ResponseResult<?> postLike(@RequestParam("blogId") String blogId){
        UtsAuthor author = currentAuthor.getAuthor();
        return ResponseResult.success(blogService.like(author.getAuthorId(),blogId));
    }

    @DeleteMapping("like")
    @ApiOperation("取消喜欢")
    public ResponseResult<?> deleteLike(@RequestParam("blogId") String blogId){
        UtsAuthor author = currentAuthor.getAuthor();
        return ResponseResult.success(blogService.unlike(author.getAuthorId(),blogId));
    }


}
