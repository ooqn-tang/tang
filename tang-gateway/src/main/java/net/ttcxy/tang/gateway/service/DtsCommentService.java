package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.gateway.entity.dto.DtsCommentDto;
import net.ttcxy.tang.gateway.model.DtsBlogComment;

import java.util.List;

/**
 * @author huanglei
 */
public interface DtsCommentService {

    /**
     * 添加评论
     * @param blogComment
     * @return
     */
    int insertComment(DtsBlogComment blogComment);

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
    List<DtsCommentDto> selectComments(String blogId);

    /**
     * 评论ID
     */
    DtsCommentDto selectComment(String commentId);
}
