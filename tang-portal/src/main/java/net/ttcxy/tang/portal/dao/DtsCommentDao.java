package net.ttcxy.tang.portal.dao;

import net.ttcxy.tang.portal.entity.dto.DtsCommentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论
 * @author huanglei
 */
public interface DtsCommentDao {
    /**
     * 通过BlogId 查询评论
     * @param blogId blogId
     * @return 评论列表
     */
    List<DtsCommentDto> selectComments(String blogId);

}
