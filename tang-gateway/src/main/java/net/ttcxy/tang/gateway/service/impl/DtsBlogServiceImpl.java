package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.dao.DtsBlogDao;
import net.ttcxy.tang.gateway.dao.mapper.DtsBlogMapper;
import net.ttcxy.tang.gateway.dao.mapper.DtsLikeDataMapper;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogDto;
import net.ttcxy.tang.gateway.entity.model.DtsBlog;
import net.ttcxy.tang.gateway.entity.model.DtsLikeData;
import net.ttcxy.tang.gateway.entity.model.DtsLikeDataExample;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.DtsBlogService;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * 博客服务
 * @author huanglei
 */
@Service
public class DtsBlogServiceImpl implements DtsBlogService {

    private static final ExecutorService executorService = ThreadUtil.newExecutor(50);

    @Autowired
    private DtsBlogDao blogDao;

    @Autowired
    private DtsBlogMapper blogMapper;

    @Autowired
    private DtsLikeDataMapper likeMapper;

    @Autowired
    private CurrentAuthorService currentAuthorServiceImpl;

    @Override
    public PageInfo<DtsBlogDto> selectBlogList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(blogDao.selectBlogList());
    }

    @Override
    public PageInfo<DtsBlogDto> search(String title, Integer page ,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(blogDao.search(title));
    }

    @Override
    public PageInfo<DtsBlogDto> selectBlogByAuthorName(String username, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(blogDao.selectByUsername(username));
    }

    @Override
    public int insertBlog(DtsBlog blog) {
        blog.setBlogId(IdUtil.fastSimpleUUID());
        blog.setAuthorId(currentAuthorServiceImpl.getAuthorId());
        DateTime date = DateUtil.date();
        blog.setUpdateDate(date);
        blog.setCreateDate(date);
        blog.setStateCode(1001);
        return blogMapper.insertSelective(blog);
    }

    @Override
    public int updateBlog(DtsBlog blog) {
        return blogMapper.updateByPrimaryKeySelective(blog);
    }

    @Override
    public int deleteBlog(String id) {

        return blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int like(String authorId, String blogId) {
        try{
            DtsLikeDataExample likeDataExample = new DtsLikeDataExample();
            likeDataExample.createCriteria().andBlogIdEqualTo(blogId).andAuthorIdEqualTo(authorId);
            DtsLikeData dtsLikeData = new DtsLikeData();
            String uuid = IdUtil.fastSimpleUUID();
            dtsLikeData.setAuthorId(authorId);
            dtsLikeData.setBlogId(blogId);
            dtsLikeData.setLikeDataId(uuid);
            dtsLikeData.setCreateDate(DateUtil.date());
            return likeMapper.insert(dtsLikeData);
        }catch (DuplicateKeyException e){
            throw new ApiException("重复插入");
        }
    }

    @Override
    public int unlike(String authorId, String blogId) {
        DtsLikeDataExample likeDataExample = new DtsLikeDataExample();
        likeDataExample.createCriteria().andBlogIdEqualTo(blogId).andAuthorIdEqualTo(authorId);
        return likeMapper.deleteByExample(likeDataExample);
    }

    @Override
    public DtsBlogDto selectBlogById(String id) {
        return blogDao.selectBlogById(id);
    }



    @Override
    public DtsBlog selectBlogInfoById(String id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public DtsBlog selectByPrimaryId(String id) {
        return blogMapper.selectByPrimaryKey(id);
    }

    @Override
    public long selectLike(String authorId, String blogId) {
        DtsLikeDataExample likeExample = new DtsLikeDataExample();
        likeExample.createCriteria().andBlogIdEqualTo(blogId).andAuthorIdEqualTo(authorId);
        return likeMapper.countByExample(likeExample);
    }

    @Override
    public PageInfo<DtsBlogDto> selectLikeBlogList(String username, Integer page,Integer pageSize) {
        return new PageInfo<>(blogDao.selectLikeBlogs(username));
    }
}
