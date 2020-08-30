package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.gateway.mapper.AdvertiseMapper;
import net.ttcxy.tang.gateway.model.Advertise;
import net.ttcxy.tang.gateway.model.AdvertiseExample;
import net.ttcxy.tang.gateway.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanglei
 */
@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertiseMapper advertiseMapper;


    /**
     * 查询全部广告信息
     */
    @Override
    public List<Advertise> selectAllAdvertise() {
        AdvertiseExample advertiseExample = new AdvertiseExample();
        advertiseExample.createCriteria();
        return advertiseMapper.selectByExample(advertiseExample);
    }

    /**
     * 根据主键查询广告信息
     * @param id 广告ID
     */
    @Override
    public Advertise selectById(String id) {
        return advertiseMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增一条广告信息
     * @param advertise 封装的广告信息
     */
    @Override
    public int insertAdvertise(Advertise advertise) {
        String uuid = IdUtil.fastSimpleUUID();
        advertise.setId(uuid);
        return advertiseMapper.insertSelective(advertise);
    }

    /**
     * 更新一条广告信息
     * @param advertise 广告
     */
    @Override
    public int updateAdvertise(Advertise advertise) {
        return advertiseMapper.updateByPrimaryKey(advertise);
    }

    /**
     * 删除一条广告信息
     * @param id 要删除的广告id
     */
    @Override
    public int deleteAdvertise(String id) {
        return advertiseMapper.deleteByPrimaryKey(id);
    }


}
