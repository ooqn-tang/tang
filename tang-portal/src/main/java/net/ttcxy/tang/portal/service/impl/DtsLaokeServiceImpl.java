package net.ttcxy.tang.portal.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.dao.DtsLaokeDao;
import net.ttcxy.tang.portal.dao.mapper.DtsLaokeMapper;
import net.ttcxy.tang.portal.entity.dto.DtsLaokeDto;
import net.ttcxy.tang.portal.entity.model.DtsLaoke;
import net.ttcxy.tang.portal.entity.model.DtsLaokeExample;
import net.ttcxy.tang.portal.service.DtsLaokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsLaokeServiceImpl implements DtsLaokeService {

    @Autowired
    private DtsLaokeMapper dtsLaokeMapper;

    @Autowired
    private DtsLaokeDao dtsLaokeDao;

    @Override
    public Integer insert(DtsLaoke laoke) {
        return dtsLaokeMapper.insert(laoke);
    }

    @Override
    public Integer delete(String id) {
        DtsLaokeExample dtsLaokeExample = new DtsLaokeExample();
        dtsLaokeExample.createCriteria().andLaokeIdEqualTo(id);
        return dtsLaokeMapper.deleteByExample(dtsLaokeExample);
    }

    @Override
    public List<DtsLaokeDto> loadList() {
        return dtsLaokeDao.selectList();
    }
}
