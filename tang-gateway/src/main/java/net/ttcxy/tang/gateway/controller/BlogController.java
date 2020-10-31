package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.entity.dto.BlogDto;
import net.ttcxy.tang.gateway.entity.LoginUser;
import net.ttcxy.tang.gateway.entity.dto.CommentDto;
import net.ttcxy.tang.gateway.service.AuthDetailsService;
import net.ttcxy.tang.gateway.service.BlogService;
import net.ttcxy.tang.gateway.service.CommentService;
import net.ttcxy.tang.model.Blog;
import net.ttcxy.tang.api.CommonResult;
import net.ttcxy.tang.model.BlogComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("blog")
@Api(tags = "BlogController", description = "对博文的增删改查")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private AuthDetailsService authDetailsServiceImpl;

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

    /**
     * 搜索跳转页面
     */
    @GetMapping("so")
    public CommonResult<PageInfo<BlogDto>> toSearch(@RequestParam(name = "page", defaultValue = "1")Integer page,
                                      @RequestParam(name = "search", defaultValue = "")String search ){
        return CommonResult.success(blogService.search(search,page));
    }

    @GetMapping("like")
    @ApiOperation("获取自己喜欢的文章")
    public CommonResult<PageInfo<BlogDto>> selectByUserLike(Integer page,String username){
        return CommonResult.success(blogService.selectLikeBlogs(username,page));
    }

    @PostMapping("insert")
    @ApiOperation("添加博客")
    public CommonResult<String> add(@RequestBody Blog blog){

        String userId = authDetailsServiceImpl.getUserId();

        if (blog !=null){
            if (StrUtil.isBlank(blog.getTitle())){
                return CommonResult.failed("请输入标题");
            }
            if (StrUtil.isBlank(blog.getMarkdown())){
                return CommonResult.failed("请输入内容");
            }
            if (StrUtil.isBlank(blog.getText())){
                return CommonResult.failed("请正确输入内容");
            }
        }
        Date date = new Date();
        String uuid = IdUtil.simpleUUID();
        blog.setId(uuid);
        blog.setUserId(userId);
        blog.setStateId(1);
        blog.setCreateDate(date);
        blog.setUpdateDate(date);

        int influenceCount = blogService.insertBlog(blog);

        if (influenceCount==1){
            return CommonResult.success("添加成功");
        }else{
            return  CommonResult.failed("添加失败");
        }
    }





    @PostMapping("comment/insert")
    @ApiOperation("添加博客评论")
    public CommonResult<CommentDto> insertComment(@RequestBody BlogComment blogComment){

        if (StrUtil.isBlank(blogComment.getContent())){
            return CommonResult.failed("评论不能为空");
        }

        LoginUser user = authDetailsServiceImpl.getUser();

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
    public CommonResult selectComment(@PathVariable("blogId") String blogId){
        Map<String,Object> map = new HashMap<>();
        map.put("comments",commentService.selectComments(blogId));
        map.put("user", authDetailsServiceImpl.getUser());
        return CommonResult.success(map);
    }

    @DeleteMapping("comment/{id}")
    @ApiOperation("删除博客评论")
    public CommonResult deleteComment(@PathVariable("id") String id){
        int count = commentService.deleteComment(id);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();

    }

    @GetMapping("load")
    @ApiOperation("加载博客信息，详细")
    public CommonResult load(@RequestParam(name="blog",required = false) String blogId){

        Blog blog = blogService.selectByPrimaryId(blogId);
        LoginUser loginUser = authDetailsServiceImpl.getUser();
        if(blog.getUserId().equals(loginUser.getId())){
            return CommonResult.success(blog);
        }else{
            return CommonResult.failed("无法修改别人的Blog");
        }
    }

    @PostMapping("update")
    @ApiOperation("更新博客")
    public CommonResult update(@RequestBody Blog blog){

        int count = blogService.updateBlog(blog);
        if (count > 0){
            return CommonResult.success(0);
        }
        return CommonResult.failed();

    }

    @GetMapping("delete/{id}")
    @ApiOperation("删除博客")
    public CommonResult delete(@PathVariable("id") String id){

        String userId = blogService.selectByPrimaryId(id).getUserId();
        if (authDetailsServiceImpl.getUser()!=null){
            if(StrUtil.equals(authDetailsServiceImpl.getUser().getId(),userId)){
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
    public CommonResult like(@PathVariable("id") String id){
        LoginUser loginUser = authDetailsServiceImpl.getUser();
        return CommonResult.success(blogService.like(loginUser.getId(),id));
    }
}
