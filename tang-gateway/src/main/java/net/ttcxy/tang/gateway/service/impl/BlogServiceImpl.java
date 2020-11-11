package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.code.security.CurrentAuthorService;
import net.ttcxy.tang.gateway.dao.BlogDao;
import net.ttcxy.tang.gateway.entity.dto.BlogDto;
import net.ttcxy.tang.gateway.service.BlogService;
import net.ttcxy.tang.mapper.DtsBlogMapper;
import net.ttcxy.tang.mapper.DtsLikeDataMapper;
import net.ttcxy.tang.mapper.StsPageViewMapper;
import net.ttcxy.tang.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * 博客服务
 * @author huanglei
 */
@Service
public class BlogServiceImpl implements BlogService {

    private static final List<String> randomBlogs= new ArrayList<>(1000);

    private static final ExecutorService executorService = ThreadUtil.newExecutor(50);

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private CurrentAuthorService currentAuthorServiceImpl;

    @Autowired
    private DtsBlogMapper blogMapper;

    @Autowired
    private StsPageViewMapper pageViewMapper;

    @Autowired
    private DtsLikeDataMapper likeMapper;

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
    public int insertBlog(DtsBlog blog) {
        int count = blogMapper.insertSelective(blog);
        if (count > 0){
            randomBlogs.add(blog.getId());
        }
        return count;
    }

    @Override
    public int updateBlog(DtsBlog blog) {
        String blogId = blog.getId();
        String userId = currentAuthorServiceImpl.getAuthorId();

        DtsBlogExample blogExample = new DtsBlogExample();
        blogExample.createCriteria().andIdEqualTo(blogId).andUserIdEqualTo(userId);


        return blogMapper.updateByExampleSelective(blog, blogExample);
    }

    @Override
    public int deleteBlog(String id) {
        int count = blogMapper.deleteByPrimaryKey(id);
        if (count > 0){
            //删除博客
            executorService.execute(()->{
                randomBlogs.remove(id);
            });
        }
        return count;
    }

    @Override
    public int like(String userId, String blogId) {
        DtsLikeDataExample likeDataExample = new DtsLikeDataExample();
        likeDataExample.createCriteria().andBlogIdEqualTo(blogId).andUserIdEqualTo(userId);
        long l = likeMapper.countByExample(likeDataExample);
        if (l > 0){
            likeMapper.deleteByExample(likeDataExample);
            return 0;
        }else{
            DtsLikeData likeData = new DtsLikeData();
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
            StsPageView pageView = new StsPageView();
            pageView.setId(IdUtil.fastSimpleUUID());
            pageView.setBlogId(id);
            pageView.setUserId(currentAuthorServiceImpl.getAuthorId());
            pageView.setCreateDatetime(new Date());
            pageViewMapper.insertSelective(pageView);
        }
        return blogDto;
    }

    @Override
    public DtsBlog selectByPrimaryId(String id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public long selectLike(String userId, String blogId) {
        DtsLikeDataExample likeExample = new DtsLikeDataExample();
        likeExample.createCriteria().andBlogIdEqualTo(blogId).andUserIdEqualTo(userId);

        return likeMapper.countByExample(likeExample);
    }



    @Override
    public PageInfo<BlogDto> selectLikeBlogs(String username, Integer page) {
        PageHelper.startPage(page,15);
        return new PageInfo<>(blogDao.selectLikeBlogs(username));
    }

    @Override
    public List<String> getRandomBlogs() {
        return randomBlogs;
    }

    @Override
    public PageInfo<BlogDto> selectBlogs(Integer page) {
        PageHelper.startPage(page,15);
        List<BlogDto> dtoList = blogDao.selectBlog();
        return new PageInfo<>(dtoList);
    }

    @Override
    public BlogDto random() {
        int randomInt = RandomUtil.randomInt(0, randomBlogs.size());
        return blogDao.selectByIdTitle(randomBlogs.get(randomInt));
    }
}
