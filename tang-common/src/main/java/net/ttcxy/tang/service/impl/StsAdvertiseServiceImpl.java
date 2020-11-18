package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.service.StsAdvertiseService;
import net.ttcxy.tang.db.mapper.DtsAdvertiseMapper;
import net.ttcxy.tang.entity.model.DtsAdvertise;
import net.ttcxy.tang.entity.model.DtsAdvertiseExample;
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
