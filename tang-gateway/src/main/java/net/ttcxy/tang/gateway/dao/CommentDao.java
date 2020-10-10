package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.CommentDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论
 * created by huanglei on 2020/10/10
 */
public interface CommentDao {

    /**
     * 添加评论
     */
    int insertComment(CommentDto commentDto);

    /**
     * 删除评论 commentId
     */
    int deleteComment(@Param("id") String id);

    /**
     * 通过BlogId 查询评论
     */
    List<CommentDto> selectComments(String blogId);

    CommentDto selectComment(String commentId);
}
