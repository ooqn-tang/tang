package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.Blog;
import net.ttcxy.tangtang.entity.params.CommentParam;
import net.ttcxy.tangtang.entity.params.BlogParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    /**
     * 筛选Blog
     */
    List<Blog> selectBlog(@Param("cls") String cls,@Param("pag") Integer pag);



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
     * 获取optionlist
     * @return
     */
    List<Map<String,String>> optionList();

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
    int updateBlog(BlogParam blogParam);

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

    Blog getBlogByUUIDTextTit(@Param("blogId") String uuid);

    int selelcLike(@Param("userId") String userId,
                   @Param("dataId") String dataId);
}
