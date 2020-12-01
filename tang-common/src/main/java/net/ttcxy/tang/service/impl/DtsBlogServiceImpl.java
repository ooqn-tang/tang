package net.ttcxy.tang.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.db.dao.DtsBlogDao;
import net.ttcxy.tang.entity.dto.DtsBlogDto;
import net.ttcxy.tang.service.CurrentMemberService;
import net.ttcxy.tang.service.DtsBlogService;
import net.ttcxy.tang.db.mapper.DtsBlogMapper;
import net.ttcxy.tang.db.mapper.DtsLikeDataMapper;
import net.ttcxy.tang.db.mapper.StsPageViewMapper;
import net.ttcxy.tang.entity.model.*;
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
    private CurrentMemberService currentMemberServiceImpl;

    @Autowired
    private DtsBlogMapper blogMapper;

    @Autowired
    private StsPageViewMapper pageViewMapper;

    @Autowired
    private DtsLikeDataMapper likeMapper;

    @Override
    public PageInfo<DtsBlogDto> getBlogList(Integer page) {
        PageHelper.startPage(page, 100);
        return new PageInfo<>(dtsBlogDao.getBlogList());
    }

    @Override
    public PageInfo<DtsBlogDto> search(String title, Integer page) {
        PageHelper.startPage(page, 15);
        return new PageInfo<>(dtsBlogDao.search(title));
    }

    @Override
    public PageInfo<DtsBlogDto> selectBlogByUsername(String username, Integer page) {
        PageHelper.startPage(page,15);
        return  new PageInfo<>(dtsBlogDao.searchByUsername(username));
    }

    @Override
    public int insertBlog(DtsBlog blog) {
        int count = blogMapper.insertSelective(blog);
        if (count > 0){
            RANDOM_BLOG.add(blog.getId());
        }
        return count;
    }

    @Override
    public int updateBlog(DtsBlog blog) {
        String blogId = blog.getId();
        String userId = currentMemberServiceImpl.getMemberId();

        DtsBlogExample blogExample = new DtsBlogExample();
        blogExample.createCriteria().andIdEqualTo(blogId).andUserIdEqualTo(userId);

        return blogMapper.updateByExampleSelective(blog, blogExample);
    }

    @Override
    public int deleteBlog(String id) {
        int count = blogMapper.deleteByPrimaryKey(id);
        if (count > 0){
            executorService.execute(()->{
                RANDOM_BLOG.remove(id);
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
    public DtsBlogDto selectBlogById(String id) {
        DtsBlogDto dtsBlogDto = dtsBlogDao.selectBlogById(id);
        if (dtsBlogDto != null){
            StsPageView pageView = new StsPageView();
            pageView.setId(IdUtil.fastSimpleUUID());
            pageView.setBlogId(id);
            pageView.setUserId(currentMemberServiceImpl.getMemberId());
            pageView.setCreateDatetime(new Date());
            pageViewMapper.insertSelective(pageView);
        }
        return dtsBlogDto;
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
    public PageInfo<DtsBlogDto> selectLikeBlogs(String username, Integer page) {
        PageHelper.startPage(page,15);
        return new PageInfo<>(dtsBlogDao.selectLikeBlogs(username));
    }

    @Override
    public List<String> getRandomBlogs() {
        return RANDOM_BLOG;
    }

    @Override
    public PageInfo<DtsBlogDto> selectBlogs(Integer page) {
        PageHelper.startPage(page,15);
        List<DtsBlogDto> dtoList = dtsBlogDao.selectBlog();
        return new PageInfo<>(dtoList);
    }

    @Override
    public DtsBlogDto random() {
        int randomInt = RandomUtil.randomInt(0, RANDOM_BLOG.size());
        return dtsBlogDao.selectByIdTitle(RANDOM_BLOG.get(randomInt));
    }
}
