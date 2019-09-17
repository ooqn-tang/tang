package net.ttcxy.tangtang.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微博页面相关操作
 * 功能：
 * 1.通过条件获取指定条数相关信息(作者，头像，时间，正文，关联url)
 * 2.获取评论列表（评论者，评论者头像，评论时间，点赞数）
 * 3.获取随机推荐微博标题
 * 3.获取广告微博标题
 */
@RequestMapping("vibo")
@Controller
public class ViboController {

    @GetMapping
    public String toVibo(){
        return "page/vibo";
    }
}
