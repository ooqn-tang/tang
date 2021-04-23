package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.gateway.dao.UtsAuthorDao;
import net.ttcxy.tang.gateway.dao.UtsFansDao;
import net.ttcxy.tang.gateway.dao.mapper.UtsFansMapper;
import net.ttcxy.tang.gateway.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.gateway.entity.dto.UtsFansDto;
import net.ttcxy.tang.gateway.entity.model.UtsFans;
import net.ttcxy.tang.gateway.entity.model.UtsFansExample;
import net.ttcxy.tang.gateway.service.UtsFansService;
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
        fans.setFansId(IdUtil.fastSimpleUUID());
        return fansMapper.insertSelective(fans);
    }

    @Override
    public int deleteFans(String fansId,String authorId){
        UtsFansExample fansExample = new UtsFansExample();
        fansExample.createCriteria()
                .andFansIdEqualTo(fansId)
                .andAuthorIdEqualTo(authorId);

        return fansMapper.deleteByExample(fansExample);
    }
}
