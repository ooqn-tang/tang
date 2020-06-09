package net.ttcxy.service.impl;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import net.ttcxy.model.Advertise;
import net.ttcxy.model.AdvertiseExample;
import net.ttcxy.mapper.AdvertiseMapper;
import net.ttcxy.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanglei
 */
@Service
@Slf4j
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertiseMapper advertiseMapper;


    /**
     * 查询全部广告信息
     * @return
     */
    @Override
    public List<Advertise> selectAllAdvertise() {
        AdvertiseExample advertiseExample = new AdvertiseExample();
        advertiseExample.createCriteria();
        return advertiseMapper.selectByExample(advertiseExample);
    }

    /**
     * 根据主键查询广告信息
     * @param id
     * @return
     */
    @Override
    public Advertise selectById(String id) {
        return advertiseMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增一条广告信息
     * @param advertise 封装的广告信息
     * @return
     */
    @Override
    public int insertAdvertise(Advertise advertise) {
        String uuid = IdUtil.fastSimpleUUID();
        advertise.setId(uuid);
        return advertiseMapper.insertSelective(advertise);
    }

    /**
     * 更新一条广告信息
     * @param advertise
     * @return
     */
    @Override
    public int updateAdvertise(Advertise advertise) {
        return advertiseMapper.updateByPrimaryKey(advertise);
    }

    /**
     * 删除一条广告信息
     * @param id 要删除的广告id
     * @return
     */
    @Override
    public int deleteAdvertise(String id) {
        return advertiseMapper.deleteByPrimaryKey(id);
    }


}
