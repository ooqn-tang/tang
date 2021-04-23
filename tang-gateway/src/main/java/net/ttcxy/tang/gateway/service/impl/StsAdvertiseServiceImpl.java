package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.gateway.dao.DtsAdvertiseDao;
import net.ttcxy.tang.gateway.dao.mapper.DtsAdvertiseMapper;
import net.ttcxy.tang.gateway.entity.model.DtsAdvertise;
import net.ttcxy.tang.gateway.service.StsAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告
 * @author huanglei
 */
@Service
public class StsAdvertiseServiceImpl implements StsAdvertiseService {

    @Autowired
    private DtsAdvertiseMapper advertiseMapper;

    @Autowired
    private DtsAdvertiseDao advertiseDao;


    @Override
    public List<DtsAdvertise> selectAllAdvertise() {
        return advertiseDao.selectAdvertiseAll();
    }

    @Override
    public DtsAdvertise selectById(String id) {
        return advertiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertAdvertise(DtsAdvertise advertise) {
        String uuid = IdUtil.fastSimpleUUID();
        advertise.setAdvertiseId(uuid);
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
