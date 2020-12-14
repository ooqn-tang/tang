package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.entity.UtsMemberLogin;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogDto;
import net.ttcxy.tang.gateway.service.CurrentMemberService;
import net.ttcxy.tang.model.DtsBlog;
import net.ttcxy.tang.model.DtsLikeData;
import net.ttcxy.tang.model.DtsLikeDataExample;
import net.ttcxy.tang.gateway.dao.DtsBlogDao;
import net.ttcxy.tang.gateway.service.DtsBlogService;
import net.ttcxy.tang.mapper.DtsBlogMapper;
import net.ttcxy.tang.mapper.DtsLikeDataMapper;
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
    private DtsBlogMapper blogMapper;

    @Autowired
    private DtsLikeDataMapper likeMapper;

    @Autowired
    private CurrentMemberService currentMemberServiceImpl;

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

        UtsMemberLogin member = currentMemberServiceImpl.getMember();

        if (member != null && StrUtil.equals(username,member.getUsername())){
            return new PageInfo<>(dtsBlogDao.searchByUsernameAuthor(username));
        }

        return new PageInfo<>(dtsBlogDao.searchByUsername(username));
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
        return blogMapper.updateByPrimaryKeySelective(blog);
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
        return dtsBlogDao.selectBlogById(id);
    }


    @Override
    public DtsBlog selectBlogInfosById(String id) {
        return dtsBlogDao.selectBlogInfoById(id);
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
    public PageInfo<DtsBlogDto> selectLikeBlogList(String username, Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(dtsBlogDao.selectLikeBlogs(username));
    }

    @Override
    public List<String> getRandomBlogIdList() {
        return RANDOM_BLOG;
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
