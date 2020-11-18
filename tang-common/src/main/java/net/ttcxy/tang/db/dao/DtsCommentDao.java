package net.ttcxy.tang.db.dao;

import net.ttcxy.tang.entity.dto.DtsCommentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论
 * @author huanglei
 */
public interface DtsCommentDao {

    /**
     * 添加评论
     * @param dtsCommentDto 评论
     * @return 影响的行数
     */
    int insertComment(DtsCommentDto dtsCommentDto);

    /**
     * 删除评论 commentId
     * @param id id
     * @return 影响的行数
     */
    int deleteComment(@Param("id") String id);

    /**
     * 通过BlogId 查询评论
     * @param blogId blogId
     * @return 评论列表
     */
    List<DtsCommentDto> selectComments(String blogId);

    /**
     * 通过评论ID查询评论
     * @param commentId 评论ID
     * @return 评论详细详细
     */
    DtsCommentDto selectComment(String commentId);
}
