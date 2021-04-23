package net.ttcxy.tang.gateway.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.entity.dto.DtsCommentDto;
import net.ttcxy.tang.gateway.entity.model.DtsBlogComment;

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
    PageInfo<DtsCommentDto> selectComments(String blogId,Integer page,Integer pageSize);

}
