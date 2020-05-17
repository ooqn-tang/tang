package net.ttcxy.tangtang.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import net.ttcxy.tangtang.dao.BlogDao;
import net.ttcxy.tangtang.dao.PageviewDao;
import net.ttcxy.tangtang.entity.BlogDto;
import net.ttcxy.tangtang.mapper.BlogMapper;
import net.ttcxy.tangtang.model.Blog;
import net.ttcxy.tangtang.model.BlogExample;
import net.ttcxy.tangtang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    AuthDetailsImpl authDetails;


    @Override
    public List<BlogDto> selectBlog(Integer pag) {
        PageHelper.startPage(pag, 10);
        return blogDao.selectBlog();
    }

    @Override
    public List<BlogDto> selectBlog() {
        long count = blogMapper.countByExample(new BlogExample());
        int size = 10;
        int limitIndex = (int) (count / size);
        int startIndex = RandomUtil.randomInt(limitIndex);
        PageHelper.startPage(startIndex, 10);
        return blogDao.selectBlog();
    }

    @Override
    public List<BlogDto> search(String title, Integer pag) {

        if (pag != null) {
            pag = pag <= 1 ? 0 : ((pag - 1) * 20);
        } else {
            pag = 0;
        }

        return blogDao.search(title, pag);
    }

    @Override
    public List<BlogDto> searchByUsername(String username) {
        return blogDao.searchByUsername(username);
    }

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int insertBlog(Blog blog) {
        return blogMapper.insertSelective(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        String blogId = blog.getId();
        String userId = authDetails.getUserId();

        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andIdEqualTo(blogId).andUserIdEqualTo(userId);

        return blogMapper.updateByExampleSelective(blog, blogExample);
    }

    @Override
    public Boolean deleteBlog(String id) {

        int code = blogDao.deleteBlog(id);

        if (code == 1) {
            return true;
        }

        return false;
    }

    @Override
    public int like(String userId, String blogId) {
        try {
            return blogDao.insertLike(userId, blogId);
        } catch (Exception e) {
            if (blogDao.deleteLike(userId, blogId) == 1) {
                return -1;
            }
            return 0;
        }
    }


    @Override
    public BlogDto getBlogByUUID(String uuid, String userId) {
        return blogDao.selectBlogById(uuid);
    }

    @Override
    public BlogDto getBlogByUUIDTextTit(String uuid) {

        return blogDao.getBlogByIdTextTit(uuid);
    }

    @Override
    public int selectLike(String userId, String blogId) {
        return blogDao.selectLike(userId, blogId);
    }

    @Override
    public int selectFavorite(String userId, String blogId) {
        return blogDao.selectFavorite(userId, blogId);
    }

    @Override
    public List<BlogDto> selectLikeBlogs(String userId) {
        return blogDao.getLikeBlogs(userId);
    }

    @Override
    public List<BlogDto> selectByUserFavorite(String username) {
        return blogDao.selectByUserFavorite(username);
    }

    @Override
    public int favorite(String id, String id1) {
        try {
            return blogDao.insertFavorite(id, id1);
        } catch (Exception e) {
            if (blogDao.deleteFavorite(id, id1) == 1) {
                return -1;
            }
            return 0;
        }
    }
}
