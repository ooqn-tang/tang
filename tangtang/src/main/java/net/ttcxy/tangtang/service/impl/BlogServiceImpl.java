package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import net.ttcxy.tangtang.dao.BlogDao;
import net.ttcxy.tangtang.entity.BlogDto;
import net.ttcxy.tangtang.mapper.BlogMapper;
import net.ttcxy.tangtang.mapper.FavoriteMapper;
import net.ttcxy.tangtang.mapper.LikeDataMapper;
import net.ttcxy.tangtang.mapper.PageViewMapper;
import net.ttcxy.tangtang.model.*;
import net.ttcxy.tangtang.service.AuthDetailsService;
import net.ttcxy.tangtang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * BlogService impl
 * @author huanglei
 */
@Service
public class BlogServiceImpl implements BlogService {


    // 读取前一千条博客
    private static List<BlogDto> blogs = new ArrayList<>(2000);

    // 随机博客
    private static final List<String> randomBlogs = new ArrayList<>(1000);

    public static List<BlogDto> getBlogs() {
        return blogs;
    }

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
    public List<BlogDto> selectBlog(Integer pag) {
        int totalPage = PageUtil.totalPage(blogs.size(), 10);
        if (pag > totalPage){
            pag = totalPage;
        }

        int[] transToStartEnd = PageUtil.transToStartEnd(pag,10);


        List<BlogDto> blogDtos = blogs.subList(transToStartEnd[0], transToStartEnd[1]);

        int randomInt = RandomUtil.randomInt(0, randomBlogs.size());

        BlogDto blogDto = blogDao.selectByIdTitle(randomBlogs.get(randomInt));

        List<BlogDto> resultBlogs = new ArrayList<>();
        resultBlogs.addAll(blogDtos);
        if (blogDto!=null){
            resultBlogs.add(0,blogDto);
        }

        return resultBlogs;
    }

    @Override
    public void blogIsNull(){
        PageHelper.startPage(0,1000);
        blogs = blogDao.selectBlog();
    }

    @Override
    public List<BlogDto> search(String title, Integer page) {
        PageHelper.startPage(page, 10);
        return blogDao.search(title);
    }

    @Override
    public List<BlogDto> searchByUsername(String username) {
        return blogDao.searchByUsername(username);
    }

    @Override
    public int insertBlog(Blog blog) {
        int count = blogMapper.insertSelective(blog);
        if (count > 0){
            randomBlogs.add(blog.getId());
            BlogDto blogDto = new BlogDto();
            blogDto.setId(blog.getId());
            blogDto.setNickname(authDetailsServiceImpl.getUser().getNickname());
            blogDto.setUsername(authDetailsServiceImpl.getUser().getUsername());
            blogDto.setCreateDate(blog.getCreateDate());
            blogs.add(0,blogDto);
        }
        return count;
    }

    @Override
    public int updateBlog(Blog blog) {
        String blogId = blog.getId();
        String userId = authDetailsServiceImpl.getUserId();

        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andIdEqualTo(blogId).andUserIdEqualTo(userId);

        new Thread(()->{
            blogs.addAll(blogDao.selectBlog());
        }).start();

        return blogMapper.updateByExampleSelective(blog, blogExample);
    }

    @Override
    public int deleteBlog(String id) {

        int count = blogMapper.deleteByPrimaryKey(id);
        if (count > 0){
            //删除随机博客
            randomBlogs.remove(id);

            new Thread(()->{
                blogIsNull();
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
    public long selectFavorite(String userId, String blogId) {
        FavoriteExample favoriteExample = new FavoriteExample();
        favoriteExample.createCriteria().andBlogIdEqualTo(blogId).andUserIdEqualTo(userId);
        return favoriteMapper.countByExample(favoriteExample);
    }

    @Override
    public List<BlogDto> selectLikeBlogs(String userId) {
        return blogDao.selectLikeBlogs(userId);
    }

    @Override
    public List<BlogDto> selectByUserFavorite(String username) {
        return blogDao.selectByUserFavorite(username);
    }

    @Override
    public int favorite(String userId, String blogId) {
        Favorite favorite = new Favorite();
        favorite.setUserId(userId);
        favorite.setBlogId(blogId);
        favorite.setCreateDate(new Date());
        try {
            return favoriteMapper.insertSelective(favorite);
        } catch (Exception e) {
            FavoriteExample favoriteExample = new FavoriteExample();
            favoriteExample.createCriteria().andBlogIdEqualTo(blogId).andUserIdEqualTo(userId);

            favoriteMapper.deleteByExample(favoriteExample);
            return 0;
        }
    }

    @Override
    public long selectBlogCount() {
        // todo 记录博客数量，需要优化性能
        return blogMapper.countByExample(new BlogExample());
    }

    public static List<String> getRandomBlogs() {
        return randomBlogs;
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
