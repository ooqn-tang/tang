package net.ttcxy.tangtang.service.impl;

import net.ttcxy.tangtang.entity.params.CommentParam;
import net.ttcxy.tangtang.entity.params.BlogParam;
import net.ttcxy.tangtang.mapper.BlogMapper;
import net.ttcxy.tangtang.entity.Blog;
import net.ttcxy.tangtang.mapper.PageviewMapper;
import net.ttcxy.tangtang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private PageviewMapper pageviewMapper;



    @Override
    public List<Blog> selectBlog(String cls,Integer pag) {

        if (pag!=null){
            pag =  pag <= 1 ? 0 : ((pag - 1) * 15);
        }

        return blogMapper.selectBlog(cls,pag);
    }

    @Override
    public int addBlog(BlogParam blogParam) {
        return blogMapper.addBlog(blogParam);
    }

    @Override
    public List<Map<String, String>> optionList() {
        return blogMapper.optionList();
    }

    @Override
    public int updateBlog(BlogParam blogParam) {
        return blogMapper.updateBlog(blogParam);
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
    public int like(String userId,String blogId) {
        try{
            return blogMapper.insertLike(userId,blogId);
        }catch (Exception e){
            if (blogMapper.deleteLike(userId,blogId)==1){
                return -1;
            }
            return 0;
        }
    }


    @Override
    public Blog getBlogByUUID(String uuid,String userId) {

        //阅读量
        pageviewMapper.insertPageview(userId,uuid);

        return blogMapper.selectBlogByUUID(uuid);
    }

    @Override
    public Blog getBlogByUUIDTextTit(String uuid){

        return blogMapper.getBlogByUUIDTextTit(uuid);
    }

    @Override
    public int selelcLike(String userId, String dataId) {
        return blogMapper.selelcLike(userId,dataId);
    }
}
