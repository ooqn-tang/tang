package net.ttcxy.tang.gateway.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogCommentDto;
import net.ttcxy.tang.gateway.entity.model.DtsBlogComment;

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
    PageInfo<DtsBlogCommentDto> selectComments(String blogId, Integer page, Integer pageSize);

    /**
     * 通过评论ID 获取评论
     * @param commentId 评论id
     * @return 评论信息
     */
    DtsBlogComment selectCommentById(String commentId);

}
