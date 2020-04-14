package net.ttcxy.tangtang.controller.web;

import cn.hutool.core.util.IdUtil;
import com.qiniu.util.Auth;
import net.ttcxy.tangtang.code.ResponseData;
import net.ttcxy.tangtang.entity.dto.Blog;
import net.ttcxy.tangtang.entity.dto.User;
import net.ttcxy.tangtang.service.AdvertisementService;
import net.ttcxy.tangtang.service.BlogService;
import net.ttcxy.tangtang.service.impl.AuthDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 对博文的增删改查
 * @author huanglei
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private AuthDetailsImpl authDetailsImpl;


    /**
     * Blog编辑器
     * @return 跳转
     */
    @GetMapping("editor")
    public String toEditor(){
        return "page/editor";
    }




    @GetMapping("userblog/{username}")
    @ResponseBody
    public ResponseData blogList(@PathVariable("username") String username,@RequestParam(value = "type",required = false) String type){

        if ("1".equals(type)){
            return ResponseData.successful(blogService.searchByUserlike(username));
        } else if ("2".equals(type)){
            return ResponseData.successful(blogService.searchByUserfavorite(username));
        }

        return  ResponseData.successful(blogService.searchByUsername(username,type));
    }

    /**
     * 博客详细信息页面
     * @return
     */
    @GetMapping("{blogId}")
    public String toBlogPage(@PathVariable("blogId") String blogId, Model model){

        //todo 专题博客需要显示专题列表

        User user = authDetailsImpl.getUser();



        String userId;

        if (user!=null){
            userId = user.getId();
        }else{
            userId = "0";
        }

        Blog blog = blogService.getBlogByUUID(blogId,userId);

        model.addAttribute(blog);
        model.addAttribute("like",blogService.selelcLike(userId,blogId));
        model.addAttribute("favorite",blogService.selelcFavorite(userId,blogId));

        return "page/blog";
    }

    /**
     * 添加博客
     * @param blog blogParam
     * @return null
     */
    @PostMapping("insert")
    @ResponseBody
    public ResponseData add(@RequestBody Blog blog){

        User user = authDetailsImpl.getUser();

        blog.setId(IdUtil.simpleUUID());

        blog.setUserId(user.getId());
        blog.setStateId("1");


        int influenceCount = blogService.addBlog(blog);

        if (influenceCount==1){
            return ResponseData.successful("successful");
        }else{
            return  ResponseData.error("error");
        }
    }

    /**
     * 更新
     * @param id 更新博客
     * @param model Blog
     * @return page/update
     */
    @GetMapping("update/{id}")
    public String toUpdate(@PathVariable("id") String id,Model model){
        Blog blog = blogService.getBlogByUUIDTextTit(id);
        String userId = authDetailsImpl.getUser().getId();
        if (blog.getUserId().equals(userId)){
            model.addAttribute("blog", blog);
        }else{
            return "redirect:/";
        }
        return "page/update";
    }

    @PostMapping("update")
    @ResponseBody
    public ResponseData update(@RequestBody Blog blog){

        String userId = blogService.getBlogByUUIDTextTit(blog.getId()).getUserId();
        User user = authDetailsImpl.getUser();
        if (!userId.equals(user.getId())){
            return ResponseData.error("无法修改别人的Blog");
        }

        blog.setUserId(user.getId());

        return  ResponseData.successful(blogService.updateBlog(blog));

    }



    /**
     * delete
     * @param id id
     * @return null
     */
    @GetMapping("delete/{id}")
    public ResponseData delete(@PathVariable("id") String id){

        System.out.println(id);
        return null;
    }


    /**
     * 查询
     * @param id 查询ID
     * @return 结果
     */
    @GetMapping("query/{id}")
    public ResponseData query(@PathVariable("id") String id){
        System.out.println(id);
        return null;
    }

   //todo 图片上传
    @PostMapping("img/upload")
    @ResponseBody
    public Map<String,String> fileUpdate(@RequestParam(value="editormd-image-file") MultipartFile multipartFile){

        String accessKey = "M6qf3dVX9P5RY1fQWnFItPjw7q8ExvUhFmGRgyHq";
        String secretKey = "EoiEXLXG_GwLox4TA0W28bVCj3tXkZwT7Le_LK1z";
        String bucket = "bucket name";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);


        multipartFile.getName();
        return null;

    }



    /**
     * 喜欢blog.如果数据库不存在，推荐，如果存在就取消。
     * @param id id
     */
    @GetMapping("/like/{id}/insert")
    @ResponseBody
    public ResponseData like(@PathVariable("id") String id){
        User user = authDetailsImpl.getUser();
        return ResponseData.successful(blogService.like(user.getId(),id));
    }

    /**
     * 如果数据库不存在，推荐，如果存在就取消。
     * @param id id
     */
    @GetMapping("/favorite/{id}/insert")
    @ResponseBody
    public ResponseData favorite(@PathVariable("id") String id){

        User user = authDetailsImpl.getUser();
        return ResponseData.successful(blogService.favorite(user.getId(),id));
    }


    /**
     * 获取博客添加Option列表
     */
    @GetMapping("/optionList")
    @ResponseBody
    public ResponseData optionList(){
        return ResponseData.successful(blogService.optionList());
    }
}
