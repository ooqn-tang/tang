package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.UtsMemberLogin;
import net.ttcxy.tang.gateway.entity.dto.DtsCommentDto;
import net.ttcxy.tang.model.DtsBlogComment;
import net.ttcxy.tang.gateway.entity.param.DtsBlogCommentParam;
import net.ttcxy.tang.gateway.service.CurrentMemberService;
import net.ttcxy.tang.gateway.service.DtsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("comment")
public class DtsBlogCommentController {

    @Autowired
    private CurrentMemberService currentMemberServiceImpl;

    @Autowired
    private DtsCommentService dtsCommentService;

    @PostMapping("insert")
    @ApiOperation("添加博客评论")
    public ResponseResult<?> insertComment(@RequestBody @Valid DtsBlogCommentParam dtsBlogCommentParam){

        UtsMemberLogin user = currentMemberServiceImpl.getMember();

        DtsBlogComment blogComment = new DtsBlogComment();
        BeanUtil.copyProperties(dtsBlogCommentParam,blogComment);

        String commentId = IdUtil.fastSimpleUUID();
        blogComment.setId(commentId);
        blogComment.setUserId(user.getId());
        blogComment.setCreateDate(new Date());
        blogComment.setStatus(1);

        int count = dtsCommentService.insertComment(blogComment);

        if (count > 0){
            DtsCommentDto dtsCommentDto = dtsCommentService.selectComment(commentId);
            return ResponseResult.success(dtsCommentDto);
        }
        return ResponseResult.failed("添加失败");

    }

    @PostMapping("delete/{id}")
    @ApiOperation("删除博客评论")
    public ResponseResult<?> deleteComment(@PathVariable("id") String id){
        int count = dtsCommentService.deleteComment(id);
        if (count > 0){
            return ResponseResult.success(count);
        }
        return ResponseResult.failed();
    }

    @GetMapping("{blogId}")
    @ApiOperation("查询博客评论")
    public ResponseResult<?> selectComment(@PathVariable("blogId") String blogId){
        Map<String,Object> map = new HashMap<>();
        map.put("comments",dtsCommentService.selectComments(blogId));
        map.put("author", currentMemberServiceImpl.getMember());
        return ResponseResult.success(map);
    }
}
