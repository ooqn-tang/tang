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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsLaokeServiceImpl implements DtsLaokeService {

    private DtsLaokeMapper dtsLaokeMapper;

    private DtsLaokeDao dtsLaokeDao;

    @Override
    public int insert(String authorId , String type , String text) {
        DtsLaoke dtsLaoke = new DtsLaoke();
        dtsLaoke.setLaokeId(IdUtil.objectId());
        dtsLaoke.setAuthorId(CurrentUtil.id());
        dtsLaoke.setText(text);
        dtsLaoke.setCreateDate(DateUtil.date());
        dtsLaoke.setType(type);
        return dtsLaokeMapper.insert(dtsLaoke);
    }

    @Override
    public int delete(String id) {
        DtsLaokeExample dtsLaokeExample = new DtsLaokeExample();
        dtsLaokeExample.createCriteria().andLaokeIdEqualTo(id);
        return dtsLaokeMapper.deleteByExample(dtsLaokeExample);
    }

    @Override
    public void loadList() {
        List<DtsLaokeDto> dtsLaokeDtos = dtsLaokeDao.selectList();
    }
}
