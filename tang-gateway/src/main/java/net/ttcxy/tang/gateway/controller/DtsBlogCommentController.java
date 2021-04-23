package net.ttcxy.tang.gateway.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.core.api.ResponseCode;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.dto.DtsCommentDto;
import net.ttcxy.tang.gateway.entity.model.DtsBlogComment;
import net.ttcxy.tang.gateway.entity.param.DtsBlogCommentParam;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.DtsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("comment")
public class DtsBlogCommentController {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private DtsCommentService dtsCommentService;

    @PostMapping("insert")
    @ApiOperation("添加博客评论")
    public ResponseResult<?> insertComment(@RequestBody DtsBlogCommentParam commentParam){
        DtsBlogComment blogComment = commentParam.getBlogComment();
        int count = dtsCommentService.insertComment(blogComment);
        if (count  > 0){
            return ResponseResult.success();
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @DeleteMapping("delete")
    @ApiOperation("删除博客评论")
    public ResponseResult<?> deleteComment(@RequestBody DtsBlogCommentParam commentParam){
        String commentId = commentParam.getBlogComment().getBlogCommentId();
        int count = dtsCommentService.deleteComment(commentId);
        if (count > 0){
            return ResponseResult.success();
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @GetMapping("list")
    @ApiOperation("查询博客评论")
    public ResponseResult<PageInfo<DtsCommentDto>> selectComment(@RequestParam("blogId") String blogId){
        PageInfo<DtsCommentDto> commentDtoPageInfo = dtsCommentService.selectComments(blogId, 1, 10);
        return ResponseResult.success(commentDtoPageInfo);
    }

    public static void main(String[] args) {
        System.out.println("sd".substring(250));
    }
}
