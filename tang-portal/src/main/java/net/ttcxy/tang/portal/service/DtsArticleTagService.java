package net.ttcxy.tang.portal.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.entity.dto.DtsArticleTagDto;
import net.ttcxy.tang.portal.entity.model.DtsArticleTag;
import net.ttcxy.tang.portal.entity.model.DtsArticleTagAuthorRelation;
import net.ttcxy.tang.portal.mapper.DtsArticleTagAuthorRelationMapper;
import net.ttcxy.tang.portal.mapper.DtsArticleTagMapper;
import net.ttcxy.tang.portal.mapper.dao.DtsArticleTagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsArticleTagService {

    @Autowired
    private DtsArticleTagDao articleTagDao;

    @Autowired
    private DtsArticleTagMapper articleTagMapper;

    @Autowired
    private DtsArticleTagAuthorRelationMapper articleTagAuthorRelationMapper;


    
    public DtsArticleTagDto selectTagInfo(String tagId) {
        DtsArticleTag tag = articleTagMapper.selectByPrimaryKey(tagId);
        return BeanUtil.toBean(tag, DtsArticleTagDto.class);
    }

    
    public PageInfo<DtsArticleTagDto> selectTagListByName(String name, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(articleTagDao.selectTagListByName(name));
    }

    
    public List<DtsArticleTagDto> selectAuthorAllTag() {
        return articleTagDao.selectAllTag();
    }

    
    public DtsArticleTagDto selectTagArticleCountListByUsername(String tagId, String username) {
        return articleTagDao.selectTagArticleCountListByUsername(tagId,username);
    }

    
    public PageInfo<DtsArticleTagDto> selectTagList(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<DtsArticleTagDto> articleTagDto = articleTagDao.selectTagList();
        return new PageInfo<>(articleTagDto);
    }

    
    public Integer insertAuthorTag(String authorId, String tagId) {
        try{
            DtsArticleTagAuthorRelation articleTagAuthorRelation = new DtsArticleTagAuthorRelation();
            articleTagAuthorRelation.setAuthorId(authorId);
            articleTagAuthorRelation.setArticleTagId(tagId);
            articleTagAuthorRelation.setCreateDate(DateUtil.date());
            articleTagAuthorRelation.setArticleTagAuthorRelationId(IdUtil.objectId());
            return articleTagAuthorRelationMapper.insert(articleTagAuthorRelation);
        }catch (DuplicateKeyException e){
            throw new ApiException("你已经添加了当前标签");
        }

    }

    
    public String insertTag(DtsArticleTag articleTag) {
        articleTag.setArticleTagId(IdUtil.objectId());
        articleTag.setCreateDate(DateUtil.date());
        DtsArticleTagDto tag = articleTagDao.selectTagByName(articleTag.getTagName());
        if (tag != null){
            return tag.getArticleTagId();
        }else{
            if (articleTagMapper.insertSelective(articleTag) > 0){
                return articleTag.getArticleTagId();
            }else{
                throw new ApiException("添加失败");
            }
        }
    }

    
    public Integer updateTag(DtsArticleTag articleTag) {
        return articleTagMapper.updateByPrimaryKeySelective(articleTag);
    }
}
