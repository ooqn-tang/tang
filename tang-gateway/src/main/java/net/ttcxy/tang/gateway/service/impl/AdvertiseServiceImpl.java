package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.mapper.AdvertiseMapper;
import net.ttcxy.tang.gateway.service.AdvertiseService;
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
    private AdvertiseMapper advertiseMapper;


    @Override
    public List<Advertise> selectAllAdvertise() {
        AdvertiseExample advertiseExample = new AdvertiseExample();
        advertiseExample.createCriteria();
        return advertiseMapper.selectByExample(advertiseExample);
    }

    @Override
    public Advertise selectById(String id) {
        return advertiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertAdvertise(Advertise advertise) {
        String uuid = IdUtil.fastSimpleUUID();
        advertise.setId(uuid);
        return advertiseMapper.insertSelective(advertise);
    }

    @Override
    public int updateAdvertise(Advertise advertise) {
        return advertiseMapper.updateByPrimaryKey(advertise);
    }

    @Override
    public int deleteAdvertise(String id) {
        return advertiseMapper.deleteByPrimaryKey(id);
    }


}
