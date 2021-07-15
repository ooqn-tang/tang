package net.ttcxy.tang.portal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.dao.DtsBlogTagDao;
import net.ttcxy.tang.portal.dao.mapper.DtsBlogTagAuthorRelationMapper;
import net.ttcxy.tang.portal.dao.mapper.DtsBlogTagMapper;
import net.ttcxy.tang.portal.entity.dto.DtsBlogTagDto;
import net.ttcxy.tang.portal.entity.model.DtsBlogTag;
import net.ttcxy.tang.portal.entity.model.DtsBlogTagAuthorRelation;
import net.ttcxy.tang.portal.service.DtsBlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsBlogTagServiceImpl implements DtsBlogTagService {

    @Autowired
    private DtsBlogTagDao blogTagDao;

    @Autowired
    private DtsBlogTagMapper blogTagMapper;

    @Autowired
    private DtsBlogTagAuthorRelationMapper blogTagAuthorRelationMapper;


    @Override
    public DtsBlogTagDto selectTagInfo(String tagId) {
        DtsBlogTag tag = blogTagMapper.selectByPrimaryKey(tagId);
        return BeanUtil.toBean(tag, DtsBlogTagDto.class);
    }

    @Override
    public PageInfo<DtsBlogTagDto> selectTagListByName(String name, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(blogTagDao.selectTagListByName(name));
    }

    @Override
    public List<DtsBlogTagDto> selectAuthorAllTag(String authorId) {
        return blogTagDao.selectAuthorAllTag(authorId);
    }

    @Override
    public DtsBlogTagDto selectTagBlogCountListByUsername(String tagId, String username) {
        return blogTagDao.selectTagBlogCountListByUsername(tagId,username);
    }

    @Override
    public PageInfo<DtsBlogTagDto> selectTagList(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<DtsBlogTagDto> blogTagDto = blogTagDao.selectTagList();
        return new PageInfo<>(blogTagDto);
    }

    @Override
    public Integer insertAuthorTag(String authorId, String tagId) {
        try{
            DtsBlogTagAuthorRelation blogTagAuthorRelation = new DtsBlogTagAuthorRelation();
            blogTagAuthorRelation.setAuthorId(authorId);
            blogTagAuthorRelation.setBlogTagId(tagId);
            blogTagAuthorRelation.setCreateDate(DateUtil.date());
            blogTagAuthorRelation.setBlogTagAuthorRelationId(IdUtil.objectId());
            return blogTagAuthorRelationMapper.insert(blogTagAuthorRelation);
        }catch (DuplicateKeyException e){
            throw new ApiException("你已经添加了当前标签");
        }

    }

    @Override
    public String insertTag(DtsBlogTag blogTag) {
        blogTag.setBlogTagId(IdUtil.objectId());
        blogTag.setCreateDate(DateUtil.date());
        DtsBlogTagDto tag = blogTagDao.selectTagByName(blogTag.getTagName());
        if (tag != null){
            return tag.getBlogTagId();
        }else{
            if (blogTagMapper.insertSelective(blogTag) > 0){
                return blogTag.getBlogTagId();
            }else{
                throw new ApiException("添加失败");
            }
        }
    }

    @Override
    public Integer updateTag(DtsBlogTag blogTag) {
        return blogTagMapper.updateByPrimaryKeySelective(blogTag);
    }
}
