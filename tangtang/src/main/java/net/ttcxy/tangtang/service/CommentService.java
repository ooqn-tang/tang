package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.Comment;

import java.util.List;

/**
 * @author ：HuangLei
 * @date ：2020/4/18 0018 18:10
 */
public interface CommentService {

    /**
     * 添加评论
     * @param comment
     * @return
     */
    boolean insertComment(Comment comment);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    boolean deleteComment(String id);

    /**
     * 查询blog的ID
     * @param blogId
     * @return
     */
    List<Comment> selectComment(String blogId);
}
