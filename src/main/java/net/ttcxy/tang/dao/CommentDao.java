package net.ttcxy.tang.dao;

import net.ttcxy.tang.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * 评论
 * @author ：HuangLei
 * @date ：2020/4/18
 */
public interface CommentDao {

    /**
     * 添加评论
     */
    @Insert("insert into blog_comment (id,blog_id,status,user_id,content,create_date)" +
            "values(#{id},#{blogId},#{status},#{userId},#{content},#{createDate})")
    int insertComment(Comment comment);

    /**
     * 删除评论 commentId
     */
    @Delete("delete from blog_comment where id = #{id}")
    int deleteComment(String id);

    /**
     * 通过BlogId 查询评论
     */
    List<Comment> selectComment(String blogId);
}
