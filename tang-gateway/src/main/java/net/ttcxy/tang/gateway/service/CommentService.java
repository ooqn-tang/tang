package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.gateway.entity.dto.CommentDto;
import net.ttcxy.tang.model.BlogComment;

import java.util.List;

/**
 * @author ：HuangLei
 * @date ：2020/4/18 0018 18:10
 */
public interface CommentService {

    /**
     * 添加评论
     * @param blogComment
     * @return
     */
    int insertComment(BlogComment blogComment);

    /**
     * 通过id删除
     * @param commentId  commentId
     * @return count
     */
    int deleteComment(String commentId);

    /**
     * 查询blog的ID
     * @param blogId
     * @return
     */
    List<CommentDto> selectComments(String blogId);

    /**
     * 评论ID
     */
    CommentDto selectComment(String commentId);
}
