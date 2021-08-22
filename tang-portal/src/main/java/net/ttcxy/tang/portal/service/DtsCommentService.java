package net.ttcxy.tang.portal.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.dto.DtsCommentDto;
import net.ttcxy.tang.portal.entity.model.DtsComment;

/**
 * @author huanglei
 */
public interface DtsCommentService {

    /**
     * 添加评论
     * @param blogComment
     * @return
     */
    int insertComment(DtsComment blogComment);

    /**
     * 通过评论ID和作者ID一起删除，减少判断
     * @param commentId  commentId
     * @return count
     */
    int deleteComment(String commentId,String authorId);

    /**
     * 查询blog的ID
     * @param blogId
     * @return
     */
    PageInfo<DtsCommentDto> selectComments(String blogId, Integer page, Integer pageSize);

    /**
     * 通过评论ID 获取评论
     * @param commentId 评论id
     * @return 评论信息
     */
    DtsComment selectCommentById(String commentId);

}
