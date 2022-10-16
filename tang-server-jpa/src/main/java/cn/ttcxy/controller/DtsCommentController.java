package cn.ttcxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.DtsCommentDto;
import cn.ttcxy.entity.model.DtsComment;
import cn.ttcxy.entity.param.DtsCommentParam;
import cn.ttcxy.service.DtsCommentService;

@RestController
@RequestMapping("api/comment")
public class DtsCommentController extends BaseController {

    @Autowired
    private DtsCommentService commentService;

    @PostMapping
    public DtsComment insert(@RequestBody DtsCommentParam commentParam){
        DtsComment comment = BeanUtil.toBean(commentParam, DtsComment.class);
        String commentId = IdUtil.objectId();
        comment.setAuthorId(authorId());
        comment.setCommentId(commentId);
        comment.setCreateDate(DateUtil.date());
        comment.setState(1);
        return commentService.insert(comment);
    }

    @DeleteMapping("{commentId}")
    public void delete(@PathVariable("commentId") String commentId){
        commentService.delete(commentId);
    }

    @GetMapping("{dataId}")
    public PageInfo<DtsCommentDto> select(
            @PathVariable("dataId") String dataId,
            @RequestParam(value = "page",defaultValue = "1") Integer page){
        return commentService.select(dataId,page);
    }

    /**
     * 评论的子评论
     */
    @GetMapping("lower/{commentId}")
    public PageInfo<DtsCommentDto> selectLower(
            @PathVariable("commentId") String commentId,
            @RequestParam(value = "page",defaultValue = "1") Integer page){
        return commentService.selectLower(commentId,page);
    }

}
