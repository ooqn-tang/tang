package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.DtsVboService;
import net.ttcxy.tang.mapper.DtsVboMapper;
import net.ttcxy.tang.model.DtsVbo;
import net.ttcxy.tang.model.DtsVboExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsVboServiceImpl implements DtsVboService {

    @Autowired
    private DtsVboMapper dtsVboMapper;

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Override
    public int insert(DtsVbo dtsVbo) {
        String authorId = currentAuthorService.getAuthorId();
        dtsVbo.setUtsAuthorUuid(authorId);
        dtsVbo.setUuid(IdUtil.fastSimpleUUID());
        DateTime date = DateUtil.date();
        dtsVbo.setCreateDate(date);
        dtsVbo.setUpdateDate(date);
        return dtsVboMapper.insertSelective(dtsVbo);
    }


    public List<DtsVbo> selectVbo(String authorUuid){
        DtsVboExample dtsVboExample = new DtsVboExample();
        dtsVboExample.createCriteria().andUtsAuthorUuidEqualTo(authorUuid);
        return dtsVboMapper.selectByExample(dtsVboExample);
    }
}
