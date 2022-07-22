package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.dto.DtsCommentDto;
import cn.ttcxy.entity.model.DtsComment;
import cn.ttcxy.entity.param.DtsCommentParam;
import cn.ttcxy.service.DtsCommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comment")
public class DtsCommentController extends BaseController {

    @Autowired
    private DtsCommentService commentService;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody DtsCommentParam commentParam){
        DtsComment comment = BeanUtil.toBean(commentParam, DtsComment.class);
        String commentId = IdUtil.objectId();
        comment.setAuthorId(authorId());
        comment.setCommentId(commentId);
        comment.setCreateDate(DateUtil.date());
        comment.setState(1);
        int count = commentService.insert(comment);
        if (count > 0){
            return ResponseEntity.ok(commentId);
        }
        throw new ApiException();
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<String> delete(@PathVariable("commentId") String commentId){
        int count = commentService.delete(commentId);
        if (count > 0){
            return ResponseEntity.ok("删除成功");
        }
        throw new ApiException();
    }

    @GetMapping("{dataId}")
    public ResponseEntity<PageInfo<DtsCommentDto>> select(
            @PathVariable("dataId") String dataId,
            @RequestParam(value = "page",defaultValue = "1") Integer page){
        return ResponseEntity.ok(commentService.select(dataId,page));
    }

    /**
     * 评论的子评论
     */
    @GetMapping("lower/{commentId}")
    public ResponseEntity<PageInfo<DtsCommentDto>> selectLower(
            @PathVariable("commentId") String commentId,
            @RequestParam(value = "page",defaultValue = "1") Integer page){
        return ResponseEntity.ok(commentService.selectLower(commentId,page));
    }

}
