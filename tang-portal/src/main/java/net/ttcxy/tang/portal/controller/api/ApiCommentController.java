package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import net.ttcxy.tang.portal.entity.dto.DtsCommentDto;
import net.ttcxy.tang.portal.entity.model.DtsComment;
import net.ttcxy.tang.portal.entity.param.DtsCommentParam;
import net.ttcxy.tang.portal.service.DtsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/comment")
@Validated
public class ApiCommentController {

    @Autowired
    private DtsCommentService dtsCommentService;

    @PostMapping("insert")
    public ResponseResult<?> insertComment(@RequestBody DtsCommentParam commentParam){
        DtsComment blogComment = BeanUtil.toBean(commentParam, DtsComment.class);
        blogComment.setAuthorId(CurrentUtil.id());
        int count = dtsCommentService.insertComment(blogComment);
        if (count > 0){
            DtsCommentDto dtsCommentDto = BeanUtil.toBean(blogComment, DtsCommentDto.class);
            CurrentAuthor author = CurrentUtil.author();
            dtsCommentDto.setUsername(author.getUsername());
            dtsCommentDto.setNickname(author.getNickname());
            return ResponseResult.success(dtsCommentDto);
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @DeleteMapping("{commentId}")
    public ResponseResult<?> deleteComment(@PathVariable("commentId") String commentId){
        String authorId = CurrentUtil.id();
        if (dtsCommentService.deleteComment(commentId, authorId) > 0){
            return ResponseResult.success("处理成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @GetMapping
    public ResponseResult<PageInfo<DtsCommentDto>> selectComment(@RequestParam("dataId") String dataId, @RequestParam("page") Integer page){
        PageInfo<DtsCommentDto> commentDtoPageInfo = dtsCommentService.selectComments(dataId, page, 10);
        return ResponseResult.success(commentDtoPageInfo);
    }
}
