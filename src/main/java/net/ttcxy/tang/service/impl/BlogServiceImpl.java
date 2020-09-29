package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.db.dao.BlogDao;
import net.ttcxy.tang.entity.dto.BlogDto;
import net.ttcxy.tang.db.mapper.BlogMapper;
import net.ttcxy.tang.db.mapper.FavoriteMapper;
import net.ttcxy.tang.db.mapper.LikeDataMapper;
import net.ttcxy.tang.db.mapper.PageViewMapper;
import net.ttcxy.tang.entity.model.*;
import net.ttcxy.tang.service.AuthDetailsService;
import net.ttcxy.tang.service.BlogService;
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
    public PageInfo<BlogDto> searchByUsername(String username, Integer page) {
        PageHelper.startPage(page,15);
        return  new PageInfo<>(blogDao.searchByUsername(username));
    }

    @Override
    public int insertBlog(net.ttcxy.tang.entity.model.Blog blog) {
        int count = blogMapper.insertSelective(blog);
        if (count > 0){
            randomBlogs.add(blog.getId());
        }
        return count;
    }

    @Override
    public int updateBlog(net.ttcxy.tang.entity.model.Blog blog) {
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
        LikeDataExample likeDataExample = new LikeDataExample();
        likeDataExample.createCriteria().andBlogIdEqualTo(blogId).andUserIdEqualTo(userId);
        long l = likeMapper.countByExample(likeDataExample);
        if (l > 0){
            likeMapper.deleteByExample(likeDataExample);
            return 0;
        }else{
            LikeData likeData = new LikeData();
            likeData.setBlogId(blogId);
            likeData.setUserId(userId);
            likeData.setCreateDate(new Date());
            return likeMapper.insertSelective(likeData);
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
    public net.ttcxy.tang.entity.model.Blog selectByPrimaryId(String id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public long selectLike(String userId, String blogId) {
        LikeDataExample likeExample = new LikeDataExample();
        likeExample.createCriteria().andBlogIdEqualTo(blogId).andUserIdEqualTo(userId);

        return likeMapper.countByExample(likeExample);
    }



    @Override
    public PageInfo<BlogDto> selectLikeBlogs(String username, Integer page) {
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
        if (blogDto !=null){
            dtos.add(0, blogDto);
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
