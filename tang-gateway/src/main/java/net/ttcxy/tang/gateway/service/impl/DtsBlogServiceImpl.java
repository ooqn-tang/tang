package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.dao.DtsBlogDao;
import net.ttcxy.tang.gateway.dao.mapper.DtsBlogMapper;
import net.ttcxy.tang.gateway.dao.mapper.DtsLikeDataMapper;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogDto;
import net.ttcxy.tang.gateway.entity.dto.UtsLoginDto;
import net.ttcxy.tang.gateway.entity.model.DtsBlog;
import net.ttcxy.tang.gateway.entity.model.DtsBlogExample;
import net.ttcxy.tang.gateway.entity.model.DtsLikeData;
import net.ttcxy.tang.gateway.entity.model.DtsLikeDataExample;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.DtsBlogService;
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
public class DtsBlogServiceImpl implements DtsBlogService {

    private static final List<String> RANDOM_BLOG = new ArrayList<>(1000);

    private static final ExecutorService executorService = ThreadUtil.newExecutor(50);

    @Autowired
    private DtsBlogDao dtsBlogDao;

    @Autowired
    private DtsBlogMapper dtsBlogMapper;

    @Autowired
    private DtsLikeDataMapper likeMapper;

    @Autowired
    private CurrentAuthorService currentAuthorServiceImpl;

    @Override
    public PageInfo<DtsBlogDto> getBlogList(Integer page,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(dtsBlogDao.getBlogList());
    }

    @Override
    public PageInfo<DtsBlogDto> search(String title, Integer page ,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(dtsBlogDao.search(title));
    }

    @Override
    public PageInfo<DtsBlogDto> selectBlogByUsername(String username, Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        UtsLoginDto login = currentAuthorServiceImpl.getAuthor();

        if (login != null && StrUtil.equals(username,login.getUsername())){
            return new PageInfo<>(dtsBlogDao.searchByUsernameAuthor(username));
        }

        return new PageInfo<>(dtsBlogDao.searchByUsername(username));
    }

    @Override
    public int insertBlog(DtsBlog blog) {
        int count = dtsBlogMapper.insertSelective(blog);
        if (count > 0){
            RANDOM_BLOG.add(blog.getBlogId());
        }
        return count;
    }

    @Override
    public int updateBlog(DtsBlog blog) {
        return dtsBlogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public int deleteBlog(String id) {
        int count = dtsBlogMapper.deleteByPrimaryKey(id);
        if (count > 0){
            executorService.execute(()->{
                RANDOM_BLOG.remove(id);
            });
        }
        return count;
    }

    @Override
    public int like(String authorId, String blogId) {
        DtsLikeDataExample likeDataExample = new DtsLikeDataExample();
        likeDataExample.createCriteria().andBlogIdEqualTo(blogId).andAuthorIdEqualTo(authorId);
        long l = likeMapper.countByExample(likeDataExample);
        if (l > 0){
            likeMapper.deleteByExample(likeDataExample);
            return 0;
        }else{
            DtsLikeData likeData = new DtsLikeData();
            likeData.setBlogId(blogId);
            likeData.setAuthorId(authorId);
            likeData.setCreateDate(new Date());
            return likeMapper.insertSelective(likeData);
        }
    }

    @Override
    public DtsBlogDto selectBlogById(String id) {
        return dtsBlogDao.selectBlogById(id);
    }



    @Override
    public DtsBlog selectBlogInfoById(String id) {
        return dtsBlogMapper.selectByPrimaryKey(id);
    }

    @Override
    public DtsBlog selectByPrimaryId(String id) {
        return dtsBlogMapper.selectByPrimaryKey(id);
    }

    @Override
    public long selectLike(String authorId, String blogId) {
        DtsLikeDataExample likeExample = new DtsLikeDataExample();
        likeExample.createCriteria().andBlogIdEqualTo(blogId).andAuthorIdEqualTo(authorId);
        return likeMapper.countByExample(likeExample);
    }

    @Override
    public PageInfo<DtsBlogDto> selectLikeBlogList(String username, Integer page,Integer pageSize) {
        return new PageInfo<>(dtsBlogDao.selectLikeBlogs(username));
    }

    @Override
    public DtsBlogDto random() {
        int randomInt = RandomUtil.randomInt(0, RANDOM_BLOG.size());
        return dtsBlogDao.selectByIdTitle(RANDOM_BLOG.get(randomInt));
    }

    @Override
    public PageInfo<DtsBlogDto> selectBlogList(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<DtsBlogDto> dtoList = dtsBlogDao.selectBlog();



        return new PageInfo<>(dtoList);
    }
}
