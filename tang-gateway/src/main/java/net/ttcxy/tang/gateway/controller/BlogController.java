package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.entity.dto.BlogDto;
import net.ttcxy.tang.gateway.entity.AuthorLogin;
import net.ttcxy.tang.gateway.entity.dto.CommentDto;
import net.ttcxy.tang.gateway.code.security.CurrentAuthorService;
import net.ttcxy.tang.gateway.entity.param.BlogCommentParam;
import net.ttcxy.tang.gateway.entity.param.BlogParam;
import net.ttcxy.tang.gateway.service.BlogService;
import net.ttcxy.tang.gateway.service.CommentService;
import net.ttcxy.tang.api.CommonResult;
import net.ttcxy.tang.model.Blog;
import net.ttcxy.tang.model.BlogComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 博客控制器
 * @author huanglei
 */
@RestController
@RequestMapping("blog")
@Api(tags = "BlogController")
@Validated
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CurrentAuthorService currentAuthorServiceImpl;

    @Autowired
    private CommentService commentService;

    @GetMapping("home/{username}")
    @ApiOperation("用户首页")
    public CommonResult<PageInfo<BlogDto>> blogList(
            @PathVariable("username") String username,
            @RequestParam(value = "page" ,defaultValue = "1")Integer page){
        return  CommonResult.success(blogService.searchByUsername(username,page));
    }

    @GetMapping("blogs")
    @ApiOperation("查询博客")
    public CommonResult<PageInfo<BlogDto>> selectBlogs(@RequestParam(value = "page" ,defaultValue = "1")Integer page){
        return CommonResult.success(blogService.selectBlogs(page));
    }

    @GetMapping("random")
    @ApiOperation("随机获取一条")
    public CommonResult<BlogDto> random(){
        return CommonResult.success(blogService.random());
    }

    @GetMapping("so")
    @ApiOperation("搜索")
    public CommonResult<PageInfo<BlogDto>> toSearch(@RequestParam(name = "page", defaultValue = "1")Integer page,
                                                    @RequestParam(name = "search", defaultValue = "")String search ){
        return CommonResult.success(blogService.search(search,page));
    }

    @GetMapping("like")
    @ApiOperation("获取自己喜欢的文章")
    public CommonResult<PageInfo<BlogDto>> selectByUserLike(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                            @RequestParam(value = "username") @NotBlank(message = "用户名不能为空") String username){
        return CommonResult.success(blogService.selectLikeBlogs(username,page));
    }

    @PostMapping("insert")
    @ApiOperation("添加博客")
    public CommonResult<String> insertBlog(@RequestBody @Valid BlogParam blogParam){
        Blog blog = new Blog();
        BeanUtil.copyProperties(blogParam,blog);

        Date date = DateUtil.date();
        String uuid = IdUtil.simpleUUID();
        blog.setId(uuid);
        blog.setUserId(currentAuthorServiceImpl.getAuthorId());
        blog.setStateId(1);
        blog.setCreateDate(date);
        blog.setUpdateDate(date);

        int count = blogService.insertBlog(blog);

        if (count > 0){
            return CommonResult.success("添加成功");
        }else{
            return  CommonResult.failed("添加失败");
        }
    }



    @PostMapping("comment/insert")
    @ApiOperation("添加博客评论")
    public CommonResult<CommentDto> insertComment(@RequestBody @Valid BlogCommentParam blogCommentParam){

        AuthorLogin user = currentAuthorServiceImpl.getAuthor();

        BlogComment blogComment = new BlogComment();
        BeanUtil.copyProperties(blogCommentParam,blogComment);

        String commentId = IdUtil.fastSimpleUUID();
        blogComment.setId(commentId);
        blogComment.setUserId(user.getId());
        blogComment.setCreateDate(new Date());
        blogComment.setStatus(1);

        int count = commentService.insertComment(blogComment);

        if (count > 0){
            CommentDto commentDto = commentService.selectComment(commentId);
            return CommonResult.success(commentDto);
        }
        return CommonResult.failed("添加失败");

    }

    @GetMapping("comment/{blogId}")
    @ApiOperation("查询博客评论")
    public CommonResult<Map<String,Object>> selectComment(@PathVariable("blogId") String blogId){
        Map<String,Object> map = new HashMap<>();
        map.put("comments",commentService.selectComments(blogId));
        map.put("author", currentAuthorServiceImpl.getAuthor());
        return CommonResult.success(map);
    }

    @DeleteMapping("comment/{id}")
    @ApiOperation("删除博客评论")
    public CommonResult<Integer> deleteComment(@PathVariable("id") String id){
        int count = commentService.deleteComment(id);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();

    }

    @GetMapping("load")
    @ApiOperation("加载博客信息，详细")
    public CommonResult<Blog> load(@RequestParam(name="blog",required = false) String blogId){

        Blog blog = blogService.selectByPrimaryId(blogId);
        AuthorLogin author = currentAuthorServiceImpl.getAuthor();
        if(blog.getUserId().equals(author.getId())){
            return CommonResult.success(blog);
        }else{
            return CommonResult.failed("无法修改别人的Blog");
        }
    }

    @PostMapping("update")
    @ApiOperation("更新博客")
    public CommonResult<Integer> update(@RequestBody BlogParam blogParam){

        Blog blog = new Blog();
        BeanUtil.copyProperties(blogParam,blog);

        int count = blogService.updateBlog(blog);
        if (count > 0){
            return CommonResult.success(0);
        }
        return CommonResult.failed();

    }

    @GetMapping("delete/{id}")
    @ApiOperation("删除博客")
    public CommonResult<String> delete(@PathVariable("id") String id){

        String userId = blogService.selectByPrimaryId(id).getUserId();
        if (currentAuthorServiceImpl.getAuthor()!=null){
            if(StrUtil.equals(currentAuthorServiceImpl.getAuthor().getId(),userId)){
                int count = blogService.deleteBlog(id);
                if(count > 0){
                    return CommonResult.success("成功删除");
                }else{
                    return CommonResult.failed("删除失败");
                }

            }else{
                return CommonResult.failed("请正确操作");
            }
        }else{
            return CommonResult.failed("请正确操作");
        }
    }

    @GetMapping("/like/{id}/insert")
    @ApiOperation("喜欢blog.如果数据库不存在，推荐，如果存在就取消。")
    public CommonResult<Integer> like(@PathVariable("id") String id){
        AuthorLogin author = currentAuthorServiceImpl.getAuthor();
        return CommonResult.success(blogService.like(author.getId(),id));
    }
}
