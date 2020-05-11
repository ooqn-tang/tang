package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.CommentDto;

import java.util.List;

/**
 * @author ：HuangLei
 * @date ：2020/4/18 0018 18:10
 */
public interface CommentService {

    /**
     * 添加评论
     * @param commentDto
     * @return
     */
    boolean insertComment(CommentDto commentDto);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    int deleteComment(String id);

    /**
     * 查询blog的ID
     * @param blogId
     * @return
     */
    List<CommentDto> selectComment(String blogId);
}
