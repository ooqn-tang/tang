package net.ttcxy.tang.portal.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.dao.UtsAuthorDao;
import net.ttcxy.tang.portal.dao.UtsFansDao;
import net.ttcxy.tang.portal.dao.mapper.UtsFansMapper;
import net.ttcxy.tang.portal.entity.dto.UtsFansDto;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.model.UtsFans;
import net.ttcxy.tang.portal.entity.model.UtsFansExample;
import net.ttcxy.tang.portal.service.UtsFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 粉丝相关服务
 * @author huanglei
 */
@Service
public class UtsFansServiceImpl implements UtsFansService {

    @Autowired
    private UtsFansDao fansDao;

    @Autowired
    private UtsFansMapper fansMapper;

    @Autowired
    private UtsAuthorDao utsAuthorDao;

    @Override
    public PageInfo<UtsFansDto> selectFansList(String authorId){
        return new PageInfo<>(fansDao.selectFansList(authorId));
    }

    @Override
    public int insertFans(UtsFans fans) {
        fans.setCreateDate(DateTime.now());
        fans.setFansId(IdUtil.objectId());
        return fansMapper.insertSelective(fans);
    }

    @Override
    public int deleteFans(String fansName,String authorId){
        UtsAuthor author = utsAuthorDao.selectAuthorByName(fansName);
        if (author != null){
            UtsFansExample fansExample = new UtsFansExample();
            fansExample.createCriteria()
                    .andBeAuthorIdEqualTo(author.getAuthorId())
                    .andAuthorIdEqualTo(authorId);
            return fansMapper.deleteByExample(fansExample);
        }
        return 0;
    }

    @Override
    public Integer isFans(String authorId, String beAuthorId) {
        return fansDao.isFans(authorId,beAuthorId);
    }
}
