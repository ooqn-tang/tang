package net.ttcxy.tangtang.service.impl;

import net.ttcxy.tangtang.entity.Blog;
import net.ttcxy.tangtang.mapper.BlogMapper;
import net.ttcxy.tangtang.mapper.PageviewMapper;
import net.ttcxy.tangtang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private PageviewMapper pageviewMapper;



    @Override
    public List<Blog> selectBlog(Integer pag) {

        if (pag!=null){
            pag =  pag <= 1 ? 0 : ((pag - 1) * 20);
        }else {
            pag = 0;
        }

        return blogMapper.selectBlog(pag);
    }

    @Override
    public List<Blog> search(String title,Integer pag) {

        if (pag!=null){
            pag =  pag <= 1 ? 0 : ((pag - 1) * 20);
        }else {
            pag = 0;
        }

        return blogMapper.search(title,pag);
    }

    @Override
    public List<Blog> searchByUsername(String username ,String type) {

        return blogMapper.searchByUsername(username);
    }


    @Override
    public int addBlog(Blog blog) {

        String markdown = blog.getMarkdown().replaceAll("<","&lt;");



        return blogMapper.addBlog(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public Boolean deleteBlog(String id) {

        int code = blogMapper.deleteBlog(id);

        if (code==1){
            return true;
        }

        return false;
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

    @Override
    public int selelcFavorite(String userId, String blogId) {
        return blogMapper.selelcFavorite(userId,blogId);
    }



    @Override
    public List<Blog> searchByUserlike(String username) {
        return blogMapper.searchByUserlike(username);
    }

    @Override
    public List<Blog> searchByUserfavorite(String username) {
        return blogMapper.searchByUserfavorite(username);
    }

    @Override
    public int favorite(String id, String id1) {
        try{
            return blogMapper.insertFavorite(id,id1);
        }catch (Exception e){
            if (blogMapper.deleteFavorite(id,id1)==1){
                return -1;
            }
            return 0;
        }
    }
}
