package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.dao.BlogDao;
import net.ttcxy.tang.gateway.entity.BlogDto;
import net.ttcxy.tang.gateway.mapper.BlogMapper;
import net.ttcxy.tang.gateway.mapper.FavoriteMapper;
import net.ttcxy.tang.gateway.mapper.LikeDataMapper;
import net.ttcxy.tang.gateway.mapper.PageViewMapper;
import net.ttcxy.tang.gateway.model.*;
import net.ttcxy.tang.gateway.service.AuthDetailsService;
import net.ttcxy.tang.gateway.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * BlogService impl
 * @author huanglei
 */
@Service
public class BlogServiceImpl implements BlogService {

    private static final List<String> randomBlogs = new ArrayList<>(1000);

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private AuthDetailsService authDetailsServiceImpl;

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Autowired
    private PageViewMapper pageViewMapper;

    @Autowired
    private LikeDataMapper likeMapper;

    @Override
    public PageInfo<BlogDto> showDt(Integer page) {
        PageHelper.startPage(page, 100);
        return new PageInfo<>(blogDao.selectBlogDt());
    }

    @Override
    public PageInfo<BlogDto> search(String title, Integer page) {
        PageHelper.startPage(page, 15);
        return new PageInfo<>(blogDao.search(title));
    }

    @Override
    public PageInfo<BlogDto> searchByUsername(String username,Integer page) {
        PageHelper.startPage(page,15);
        return  new PageInfo<>(blogDao.searchByUsername(username));
    }

    @Override
    public int insertBlog(Blog blog) {
        int count = blogMapper.insertSelective(blog);
        if (count > 0){
            randomBlogs.add(blog.getId());
        }
        return count;
    }

    @Override
    public int updateBlog(Blog blog) {
        String blogId = blog.getId();
        String userId = authDetailsServiceImpl.getUserId();

        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andIdEqualTo(blogId).andUserIdEqualTo(userId);


        return blogMapper.updateByExampleSelective(blog, blogExample);
    }

    @Override
    public int deleteBlog(String id) {

        int count = blogMapper.deleteByPrimaryKey(id);
        if (count > 0){
            //删除随机博客
            new Thread(()->{
                randomBlogs.remove(id);
            }).start();
        }
        return count;
    }

    @Override
    public int like(String userId, String blogId) {

        LikeData likeData = new LikeData();
        likeData.setBlogId(blogId);
        likeData.setUserId(userId);
        likeData.setCreateDate(new Date());
        try {
            return likeMapper.insertSelective(likeData);
        } catch (Exception e) {
            LikeDataExample likeExample = new LikeDataExample();
            likeExample.createCriteria().andBlogIdEqualTo(blogId).andUserIdEqualTo(userId);
            likeMapper.deleteByExample(likeExample);
            return 0;

        }
    }

    @Override
    public BlogDto selectBlogById(String id) {
        BlogDto blogDto = blogDao.selectBlogById(id);
        if (blogDto != null){
            PageView pageView = new PageView();
            pageView.setId(IdUtil.fastSimpleUUID());
            pageView.setBlogId(id);
            pageView.setUserId(authDetailsServiceImpl.getUserId());
            pageView.setCreateDatetime(new Date());
            pageViewMapper.insertSelective(pageView);
        }
        return blogDto;
    }

    @Override
    public Blog selectByPrimaryId(String id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public long selectLike(String userId, String blogId) {
        LikeDataExample likeExample = new LikeDataExample();
        likeExample.createCriteria().andBlogIdEqualTo(blogId).andUserIdEqualTo(userId);

        return likeMapper.countByExample(likeExample);
    }



    @Override
    public PageInfo<BlogDto> selectLikeBlogs(String username,Integer page) {
        PageHelper.startPage(page,15);
        return new PageInfo<>(blogDao.selectLikeBlogs(username));
    }





    public static List<String> getRandomBlogs() {
        return randomBlogs;
    }

    @Override
    public PageInfo<BlogDto> selectBlogs(Integer page) {
        int randomInt = RandomUtil.randomInt(0, randomBlogs.size());
        BlogDto blogDto = blogDao.selectByIdTitle(randomBlogs.get(randomInt));

        PageHelper.startPage(page,15);
        List<BlogDto> dtos = blogDao.selectBlog();
        if (blogDto!=null){
            dtos.add(0,blogDto);
        }
        return new PageInfo<>(dtos);
    }

    @Override
    public BlogDto random() {
        int randomInt = RandomUtil.randomInt(0, randomBlogs.size());
        return blogDao.selectByIdTitle(randomBlogs.get(randomInt));
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list);
        list.add(0,"0");
        System.out.println(list);
    }
}
