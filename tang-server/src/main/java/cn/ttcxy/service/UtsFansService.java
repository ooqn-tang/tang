package cn.ttcxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.UtsFansDto;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.model.UtsFans;
import cn.ttcxy.entity.model.UtsFansExample;
import cn.ttcxy.mapper.UtsFansMapper;
import cn.ttcxy.mapper.dao.UtsFansDao;

/**
 * 粉丝相关服务
 */
@Service
public class UtsFansService {

    @Autowired
    private UtsFansDao fansDao;

    @Autowired
    private UtsFansMapper fansMapper;

    @Autowired
    private UtsAuthorService authorService;

    
    public PageInfo<UtsFansDto> selectFansList(String authorId){
        return new PageInfo<>(fansDao.selectFansList(authorId));
    }

    
    public int insertFans(UtsFans fans) {
        fans.setCreateDate(DateTime.now());
        fans.setFansId(IdUtil.objectId());
        return fansMapper.insertSelective(fans);
    }

    
    public int deleteFans(String fansName,String authorId){
        UtsAuthor author = authorService.selectAuthorByName(fansName);
        if (author != null){
            UtsFansExample fansExample = new UtsFansExample();
            fansExample.createCriteria()
                    .andBeAuthorIdEqualTo(author.getAuthorId())
                    .andAuthorIdEqualTo(authorId);
            return fansMapper.deleteByExample(fansExample);
        }
        return 0;
    }

    
    public Integer isFans(String authorId, String beAuthorId) {
        return fansDao.isFans(authorId,beAuthorId);
    }
}