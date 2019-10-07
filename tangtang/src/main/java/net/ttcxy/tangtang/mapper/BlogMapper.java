package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.Blog;
import net.ttcxy.tangtang.entity.params.CommentParam;
import net.ttcxy.tangtang.entity.params.BlogParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {

    /**
     * 筛选Blog
     */
    List<Blog> selectBlogCls(@Param("cls") String cls);

    /**
     * 查询Blog
     * @return
     */
    List<Blog> selectBlog();

    /**
     * 通过BlogId获取博客是否存在
     * @param blogId
     * @return
     */
    int isNotBlog(@Param("blogId")String blogId);

    /**
     * 通过UUID获取blog信息
     * @param uuid
     * @return
     */
    Blog selectBlogByUUID(String uuid);

    /**
     * 添加blog
     * @param blogParam
     * @return
     */
    int addBlog(BlogParam blogParam);

    /**
     * 更新博客
     * @return
     */
    int updateBlog(Blog blog);

    /**
     * 删除博客
     * @return
     */
    int deleteBlog(@Param("id") String id);

    /**
     * 评论
     * @param commentParam
     * @return
     */
    int addComment(CommentParam commentParam);

    int deleteLike(@Param("userId") String userId,
                   @Param("dataId") String dataId);

    int insertLike(@Param("userId") String userId,
                   @Param("dataId") String dataId);
}
