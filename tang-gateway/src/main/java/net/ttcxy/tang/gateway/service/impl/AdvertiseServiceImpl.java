package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.gateway.service.AdvertiseService;
import net.ttcxy.tang.mapper.DtsAdvertiseMapper;
import net.ttcxy.tang.model.DtsAdvertise;
import net.ttcxy.tang.model.DtsAdvertiseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告
 * @author huanglei
 */
@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private DtsAdvertiseMapper advertiseMapper;


    @Override
    public List<DtsAdvertise> selectAllAdvertise() {
        DtsAdvertiseExample advertiseExample = new DtsAdvertiseExample();
        advertiseExample.createCriteria();
        return advertiseMapper.selectByExample(advertiseExample);
    }

    @Override
    public DtsAdvertise selectById(String id) {
        return advertiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertAdvertise(DtsAdvertise advertise) {
        String uuid = IdUtil.fastSimpleUUID();
        advertise.setId(uuid);
        return advertiseMapper.insertSelective(advertise);
    }

    @Override
    public int updateAdvertise(DtsAdvertise advertise) {
        return advertiseMapper.updateByPrimaryKey(advertise);
    }

    @Override
    public int deleteAdvertise(String id) {
        return advertiseMapper.deleteByPrimaryKey(id);
    }


}
