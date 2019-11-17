package net.ttcxy.tangtang.service;

import net.ttcxy.tangtang.entity.Blog;
import net.ttcxy.tangtang.entity.params.CommentParam;
import net.ttcxy.tangtang.entity.params.BlogParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogService {

    /**
     * 查询blog
     * @return
     */
    List<Blog> selectBlog(String cls,Integer pag);

    Blog getBlogByUUID(String uuid,String userId);

    //添加blog
    int addBlog(BlogParam blogParam);

    List<Map<String,String>> optionList();

    //更新博客
    int updateBlog(BlogParam blogParam);

    //删除博客
    int deleteBlog();

    int addComment(CommentParam commentParam) throws Exception;

    /**
     * 喜欢blog
     * @param userId
     * @param blogId
     */
    int like(String userId,String blogId);

    Blog getBlogByUUIDTextTit(String blogId);

    int selelcLike(String userId,String dataId);
}