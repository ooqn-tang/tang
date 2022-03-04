package net.ttcxy.tang.portal.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsCommentDto;
import net.ttcxy.tang.portal.entity.model.DtsComment;
import net.ttcxy.tang.portal.entity.param.DtsCommentParam;
import net.ttcxy.tang.portal.service.CtsCoinService;
import net.ttcxy.tang.portal.service.DtsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comment")
public class DtsCommentController {

    @Autowired
    private DtsCommentService commentService;

    @Autowired
    private CtsCoinService ptsCreditService;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody DtsCommentParam commentParam){
        DtsComment comment = BeanUtil.toBean(commentParam, DtsComment.class);
        String commentId = IdUtil.objectId();
        comment.setAuthorId(CurrentUtil.id());
        comment.setCommentId(commentId);
        comment.setCreateDate(DateUtil.date());
        int count = commentService.insert(comment);
        if (count > 0){
            ptsCreditService.commentCoin();
            return ResponseEntity.ok(commentId);
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @DeleteMapping("{commentId}")
    public ResponseEntity<String> delete(@PathVariable("commentId") String commentId){
        int count = commentService.delete(commentId);
        if (count > 0){
            return ResponseEntity.ok("删除成功");
        }
        throw new ApiException(ResponseCode.FAILED);
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
