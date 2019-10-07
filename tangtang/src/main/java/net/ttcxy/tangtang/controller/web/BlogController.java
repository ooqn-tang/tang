package net.ttcxy.tangtang.controller.web;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tangtang.code.ResponseData;
import net.ttcxy.tangtang.code.SessionKey;
import net.ttcxy.tangtang.entity.*;
import net.ttcxy.tangtang.entity.params.BlogParam;
import net.ttcxy.tangtang.entity.params.CommentParam;
import net.ttcxy.tangtang.service.BlogService;
import net.ttcxy.tangtang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * 对博文的增删改查
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("editor")
    public String toEditor(){
        return "page/editor";
    }

    //添加博客，
    @PostMapping("editor")
    @ResponseBody
    public ResponseData add(@RequestBody @Valid BlogParam blogParam){

        User user = (User)httpSession.getAttribute(SessionKey.LOGIN_USER_SESSION_KEY);

        blogParam.setId(IdUtil.fastSimpleUUID());

        blogParam.setUserId(user.getId());
        blogParam.setStateId("1");

        Integer influenceCount = blogService.addBlog(blogParam);

        if (influenceCount==1){
            return ResponseData.successful("successful");
        }else{
            return  ResponseData.error("error");
        }
    }

    //添加评论
    @PostMapping("/comment")
    @ResponseBody
    public ResponseData addComment(@RequestBody Map<String,String> requestBody){

        User user = (User)httpSession.getAttribute(SessionKey.LOGIN_USER_SESSION_KEY);

        String comment = requestBody.get("comment");

        String userId = user.getId();
        String blogId = requestBody.get("blogId");

        CommentParam commentParam = new CommentParam();
        commentParam.setId(IdUtil.fastSimpleUUID());
        commentParam.setBlogId(blogId);
        commentParam.setCommentContent(comment);
        commentParam.setUserId(userId);

        ResponseData responseData = null;

        try {
            responseData = ResponseData.successful(blogService.addComment(commentParam));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.error("BlogDoecNotExist");
        }

        return ResponseData.successful(responseData);


    }




    /**
     * 通过博客ID获取博客页面
     * @param blogId
     * @return
     */
    @GetMapping("{blogId}")
    public String toBlogInfo(@PathVariable("blogId") String blogId, Model model){

        User user = (User)httpSession.getAttribute(SessionKey.LOGIN_USER_SESSION_KEY);

        String userId = null;

        if (user!=null){
            userId = user.getId();
        }else{
            userId = "0";
        }

        Blog blog = blogService.getBlogByUUID(blogId,userId);

        model.addAttribute(blog);

        return "page/blogInfo";
    }

    //删除博客
    @GetMapping("delete/{id}")
    public ResponseData delete(@PathVariable("id") String id){

        return null;
    }

    //删除博客
    @GetMapping("update/{id}")
    public ResponseData update(@PathVariable("id") String id){



        return null;
    }

    //删除博客
    @GetMapping("query/{id}")
    public ResponseData query(@PathVariable("id") String id){



        return null;
    }

    @GetMapping("queryList")
    public ResponseData queryList(@PathVariable("id") String id){
        return null;
    }

    /**
     * 如果数据库不存在，推荐，如果存在就取消。
     * @param id
     * @return
     */
    @GetMapping("/like/{id}/insert")
    @ResponseBody
    public ResponseData like(@PathVariable("id") String id){

        User user = (User)httpSession.getAttribute(SessionKey.LOGIN_USER_SESSION_KEY);

        return ResponseData.successful(blogService.like(user.getId(),id));
    }
}
