package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsBlogCommentDto;
import net.ttcxy.tang.portal.entity.model.DtsBlogComment;
import net.ttcxy.tang.portal.entity.param.DtsBlogCommentParam;
import net.ttcxy.tang.portal.service.DtsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comment")
@Validated
public class ApiBlogCommentController {

    @Autowired
    private DtsCommentService dtsCommentService;

    @PostMapping
    public ResponseResult<?> insertComment(@RequestBody DtsBlogCommentParam commentParam){
        DtsBlogComment blogComment = BeanUtil.toBean(commentParam, DtsBlogComment.class);
        blogComment.setAuthorId(CurrentUtil.id());
        int count = dtsCommentService.insertComment(blogComment);
        if (count  > 0){
            return ResponseResult.success("处理成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @DeleteMapping("{commentId}")
    public ResponseResult<?> deleteComment(@PathVariable("commentId") String commentId){
        String authorId = CurrentUtil.id();
        DtsBlogComment blogComment = dtsCommentService.selectCommentById(commentId);

        if (blogComment == null){
            throw new ApiException(ResponseCode.VALIDATE_FAILED);
        }

        if (StrUtil.equals(blogComment.getAuthorId(),authorId)) {
            int count = dtsCommentService.deleteComment(commentId);
            if (count > 0){
                return ResponseResult.success("处理成功");
            }
        }

        throw new ApiException(ResponseCode.FAILED);
    }

    @GetMapping("list")
    public ResponseResult<PageInfo<DtsBlogCommentDto>> selectComment(@RequestParam("blogId") String blogId,@RequestParam("page") Integer page){
        PageInfo<DtsBlogCommentDto> commentDtoPageInfo = dtsCommentService.selectComments(blogId, page, 10);
        return ResponseResult.success(commentDtoPageInfo);
    }
}
