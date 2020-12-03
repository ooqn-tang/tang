package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.entity.UtsMemberLogin;
import net.ttcxy.tang.entity.dto.DtsBlogDto;
import net.ttcxy.tang.entity.model.DtsBlog;
import net.ttcxy.tang.entity.param.DtsBlogParam;
import net.ttcxy.tang.service.CurrentMemberService;
import net.ttcxy.tang.service.DtsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 博客控制器
 * @author huanglei
 */
@RestController
@RequestMapping("blog")
@Api(tags = "BlogController")
@Validated
public class DtsBlogController {

    @Autowired
    private DtsBlogService blogService;

    @Autowired
    private CurrentMemberService currentMemberServiceImpl;

    @GetMapping("home/{username}")
    @ApiOperation("用户首页")
    public ResponseResult<?> blogList(
            @PathVariable("username") String username,
            @RequestParam(value = "page" ,defaultValue = "1")Integer page){
        return  ResponseResult.success(blogService.selectBlogByUsername(username,page));
    }

    @GetMapping("random")
    @ApiOperation("随机获取一条")
    public ResponseResult<?> random(){
        return ResponseResult.success(blogService.random());
    }

    @GetMapping("so")
    @ApiOperation("搜索")
    public ResponseResult<?> toSearch(@RequestParam(name = "page", defaultValue = "1")Integer page,
                                                      @RequestParam(name = "search", defaultValue = "")String search ){
        return ResponseResult.success(blogService.search(search,page));
    }

    @GetMapping("like")
    @ApiOperation("获取自己喜欢的文章")
    public ResponseResult<?> selectByUserLike(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                              @RequestParam(value = "username") @NotBlank(message = "用户名不能为空") String username){
        return ResponseResult.success(blogService.selectLikeBlogs(username,page));
    }

    @GetMapping("delete/{id}")
    @ApiOperation("删除博客")
    public ResponseResult<?> delete(@PathVariable("id") String id){
        String userId = blogService.selectByPrimaryId(id).getUserId();
        int count = 0;
        if (currentMemberServiceImpl.getMember()!=null){
            if(StrUtil.equals(currentMemberServiceImpl.getMember().getId(),userId)){
                count = blogService.deleteBlog(id);
            }
        }
        if(count > 0){
            return ResponseResult.success();
        }else{
            return ResponseResult.failed();
        }
    }

    @PostMapping("update")
    @ApiOperation("更新博客")
    public ResponseResult<?> update(@RequestBody DtsBlogParam dtsBlogParam){
        DtsBlog blog = new DtsBlog();
        BeanUtil.copyProperties(dtsBlogParam,blog);

        String blogId = blog.getId();
        DtsBlogDto dtsBlogDto = blogService.selectBlogById(blogId);

        String userId = dtsBlogDto.getUserId();
        if (StrUtil.equals(userId,currentMemberServiceImpl.getMemberId())){
            DateTime date = DateUtil.date();
            blog.setUpdateDate(date);
            blog.setStateId(1);

            int count = blogService.updateBlog(blog);
            if (count > 0){
                return ResponseResult.success(0);
            }
            return ResponseResult.failed();
        }
        return ResponseResult.failed("无法修改别人的内容");
    }

    @GetMapping("blogs")
    @ApiOperation("查询博客")
    public ResponseResult<?> selectBlogs(@RequestParam(value = "page" ,defaultValue = "1")Integer page){
        return ResponseResult.success(blogService.selectBlogs(page));
    }

    @GetMapping("load")
    @ApiOperation("加载博客信息，详细")
    public ResponseResult<?> load(@RequestParam(name="blog",required = false) String blogId){
        DtsBlog blog = blogService.selectBlogInfosById(blogId);
        UtsMemberLogin memberLogin = currentMemberServiceImpl.getMember();
        if(blog.getUserId().equals(memberLogin.getId())){
            return ResponseResult.success(blog);
        }else{
            return ResponseResult.failed("无法修改别人的Blog");
        }
    }

    @GetMapping("/like/{id}/insert")
    @ApiOperation("喜欢blog.如果数据库不存在，推荐，如果存在就取消。")
    public ResponseResult<?> like(@PathVariable("id") String id){
        UtsMemberLogin author = currentMemberServiceImpl.getMember();
        return ResponseResult.success(blogService.like(author.getId(),id));
    }
}
