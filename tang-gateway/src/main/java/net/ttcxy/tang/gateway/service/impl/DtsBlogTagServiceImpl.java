package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.dao.DtsBlogTagDao;
import net.ttcxy.tang.gateway.dao.mapper.DtsBlogTagMapper;
import net.ttcxy.tang.gateway.entity.dto.DtsBlogTagDto;
import net.ttcxy.tang.gateway.entity.model.DtsBlogTag;
import net.ttcxy.tang.gateway.service.DtsBlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsBlogTagServiceImpl implements DtsBlogTagService {

    @Autowired
    private DtsBlogTagDao blogTagDao;

    @Autowired
    private DtsBlogTagMapper blogTagMapper;


    @Override
    public DtsBlogTagDto selectTagInfo(String tagId) {
        DtsBlogTag tag = blogTagMapper.selectByPrimaryKey(tagId);
        return BeanUtil.toBean(tag, DtsBlogTagDto.class);
    }

    @Override
    public DtsBlogTagDto selectTagBlogListByUsername(String tagId, String username) {
        return blogTagDao.selectTagBlogListByUsername(tagId,username);
    }

    @Override
    public PageInfo<DtsBlogTagDto> selectTagList(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<DtsBlogTagDto> blogTagDto = blogTagDao.selectTagList();
        return new PageInfo<>(blogTagDto);
    }

    @Override
    public Integer insertTag(DtsBlogTag blogTag) {
        blogTag.setBlogTagId(IdUtil.fastSimpleUUID());
        blogTag.setCreateDate(DateUtil.date());
        return blogTagMapper.insert(blogTag);
    }

    @Override
    public Integer updateTag(DtsBlogTag blogTag) {
        return blogTagMapper.updateByPrimaryKeySelective(blogTag);
    }
}
