package net.ttcxy.tang.portal.service.impl;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.mapper.DtsBlogMapper;
import net.ttcxy.tang.portal.mapper.DtsBlogTagRelationMapper;
import net.ttcxy.tang.portal.mapper.DtsLikeBlogMapper;
import net.ttcxy.tang.portal.mapper.dao.DtsBlogDao;
import net.ttcxy.tang.portal.entity.dto.DtsBlogDto;
import net.ttcxy.tang.portal.entity.model.*;
import net.ttcxy.tang.portal.service.DtsBlogService;
import net.ttcxy.tang.portal.service.DtsBlogSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * 博客服务
 * @author huanglei
 */
@Service
public class DtsBlogServiceImpl implements DtsBlogService {

    private static final ExecutorService executorService = ThreadUtil.newExecutor(50);

    private static List<DtsBlogDto> cache = new ArrayList<>();

    @Autowired
    private DtsBlogDao blogDao;

    @Autowired
    private DtsBlogMapper blogMapper;

    @Autowired
    private DtsBlogTagRelationMapper blogTagRelationMapper;

    @Autowired
    private DtsLikeBlogMapper likeMapper;

    @Autowired
    private DtsBlogSubjectService blogSubjectService;

    @Override
    public PageInfo<DtsBlogDto> selectBlogList(String tagName, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(blogDao.selectBlogList(tagName));
    }

    @Override
    public PageInfo<DtsBlogDto> search(String title, Integer page ,Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(blogDao.search(title));
    }

    @Override
    public PageInfo<DtsBlogDto> selectBlogByAuthorName(String username, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(blogDao.selectBlogListByUsername(username));
    }

    @Override
    public int insertBlog(DtsBlog blog) {
        return blogMapper.insertSelective(blog);
    }

    @Override
    public int updateBlog(DtsBlog blog,String subjectId,List<String> tagIdList) {
        DtsBlogTagRelation blogTagRelation = new DtsBlogTagRelation();
        int i = blogMapper.updateByPrimaryKeySelective(blog);

        DtsBlogTagRelationExample blogTagRelationExample = new DtsBlogTagRelationExample();
        blogTagRelationExample.createCriteria().andBlogIdEqualTo(blog.getBlogId());

        blogTagRelationMapper.deleteByExample(blogTagRelationExample);

        for (String tagId : tagIdList) {
            blogTagRelation.setBlogTagRelationId(IdUtil.objectId());
            blogTagRelation.setBlogId(blog.getBlogId());
            blogTagRelation.setBlogTagId(tagId);
            blogTagRelationMapper.insert(blogTagRelation);
        }

        blogSubjectService.deleteBlogSubjectBlogId(blog.getBlogId());

        if (i > 0 && StrUtil.isNotBlank(subjectId)){
            blogSubjectService.insertBlogToSubject(blog.getBlogId(), subjectId);
        }

        return i;
    }

    @Override
    public int deleteBlog(String id) {
        return blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int like(String authorId, String blogId) {
        try{
            DtsLikeBlogExample likeDataExample = new DtsLikeBlogExample();
            likeDataExample.createCriteria().andBlogIdEqualTo(blogId).andAuthorIdEqualTo(authorId);
            DtsLikeBlog dtsLikeBlog = new DtsLikeBlog();
            String id = IdUtil.objectId();
            dtsLikeBlog.setAuthorId(authorId);
            dtsLikeBlog.setBlogId(blogId);
            dtsLikeBlog.setLikeBlogId(id);
            dtsLikeBlog.setCreateDate(DateUtil.date());
            return likeMapper.insert(dtsLikeBlog);
        }catch (DuplicateKeyException e){
            throw new ApiException("重复插入");
        }
    }

    @Override
    public int unlike(String authorId, String blogId) {
        DtsLikeBlogExample likeDataExample = new DtsLikeBlogExample();
        likeDataExample.createCriteria().andBlogIdEqualTo(blogId).andAuthorIdEqualTo(authorId);
        return likeMapper.deleteByExample(likeDataExample);
    }

    @Override
    public DtsBlogDto selectBlogById(String id) {
        return blogDao.selectBlogById(id);
    }

    @Override
    public DtsBlogDto selectBlogAllById(String id) {
        return blogDao.selectBlogAllById(id);
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
        DtsLikeBlogExample likeExample = new DtsLikeBlogExample();
        likeExample.createCriteria().andBlogIdEqualTo(blogId).andAuthorIdEqualTo(authorId);
        return likeMapper.countByExample(likeExample);
    }

    @Override
    public PageInfo<DtsBlogDto> selectLikeBlogList(String username, Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(blogDao.selectLikeBlogs(username));
    }

    @Override
    public List<DtsBlogDto> selectBlogListRandom() {
        List<DtsBlogDto> set = new ArrayList<>();
        cache = blogDao.selectBlogList1000();
        while(set.size() <= 10){
            Random random = new Random();
            int n = random.nextInt(cache.size());
            DtsBlogDto dtsBlogDto = cache.get(n);
            set.add(dtsBlogDto);
        }
       return set;
    }
}
