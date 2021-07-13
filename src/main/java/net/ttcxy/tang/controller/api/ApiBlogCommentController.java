package net.ttcxy.tang.controller.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.core.api.ApiException;
import net.ttcxy.tang.core.api.ResponseCode;
import net.ttcxy.tang.core.api.ResponseResult;
import net.ttcxy.tang.entity.dto.DtsBlogCommentDto;
import net.ttcxy.tang.entity.model.DtsBlogComment;
import net.ttcxy.tang.entity.param.DtsBlogCommentParam;
import net.ttcxy.tang.service.CurrentAuthorService;
import net.ttcxy.tang.service.DtsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comment")
@Validated
@Api("博客评论")
public class ApiBlogCommentController {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private DtsCommentService dtsCommentService;

    @PostMapping
    @ApiOperation("添加博客评论")
    public ResponseResult<?> insertComment(@RequestBody DtsBlogCommentParam commentParam){
        DtsBlogComment blogComment = BeanUtil.toBean(commentParam, DtsBlogComment.class);
        blogComment.setAuthorId(currentAuthorService.getAuthorId());
        int count = dtsCommentService.insertComment(blogComment);
        if (count  > 0){
            return ResponseResult.success();
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @DeleteMapping("{commentId}")
    @ApiOperation("删除博客评论")
    public ResponseResult<?> deleteComment(@PathVariable("commentId") String commentId){
        String authorId = currentAuthorService.getAuthorId();
        DtsBlogComment blogComment = dtsCommentService.selectCommentById(commentId);

        if (blogComment == null){
            throw new ApiException(ResponseCode.VALIDATE_FAILED);
        }

        if (StrUtil.equals(blogComment.getAuthorId(),authorId)) {
            int count = dtsCommentService.deleteComment(commentId);
            if (count > 0){
                return ResponseResult.success();
            }
        }

        throw new ApiException(ResponseCode.FAILED);
    }

    @GetMapping("list")
    @ApiOperation("查询博客评论")
    public ResponseResult<PageInfo<DtsBlogCommentDto>> selectComment(@RequestParam("blogId") String blogId,@RequestParam("page") Integer page){
        PageInfo<DtsBlogCommentDto> commentDtoPageInfo = dtsCommentService.selectComments(blogId, page, 10);
        return ResponseResult.success(commentDtoPageInfo);
    }

    public static void main(String[] args) {
        System.out.println("sd".substring(250));
    }
}
