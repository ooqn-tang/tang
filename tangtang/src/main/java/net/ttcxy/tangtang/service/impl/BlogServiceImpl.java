package net.ttcxy.tangtang.service.impl;

import net.ttcxy.tangtang.entity.params.CommentParam;
import net.ttcxy.tangtang.entity.params.BlogParam;
import net.ttcxy.tangtang.mapper.BlogMapper;
import net.ttcxy.tangtang.entity.Blog;
import net.ttcxy.tangtang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> selectBlogCls(String cls) {



        return blogMapper.selectBlogCls(cls);
    }

    @Override
    public List<Blog> selectBlog() {
        return blogMapper.selectBlog();
    }

    @Override
    public int addBlog(BlogParam blogParam) {
        return blogMapper.addBlog(blogParam);
    }

    @Override
    public int updateBlog() {
        return 0;
    }

    @Override
    public int deleteBlog() {
        return 0;
    }

    @Override
    public int addComment(CommentParam commentParam) throws Exception {


        if(1!=blogMapper.isNotBlog(commentParam.getBlogId())){
            throw new Exception("Blog does not exist，No comment");
        }

        return blogMapper.addComment(commentParam);
    }

    @Override
    public Blog getBlogByUUID(String uuid) {
        return blogMapper.getBlogByUUID(uuid);
    }
}
