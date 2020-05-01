package net.ttcxy.tangtang.service.impl;

import net.ttcxy.tangtang.entity.Advertise;
import net.ttcxy.tangtang.mapper.AdvertisementMapper;
import net.ttcxy.tangtang.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementMapper advertisementMapper;

    /**
     * 查询全部广告信息
     * @return
     */
    @Override
    public List<Advertise> selectAllAdvertisement() {
        return advertisementMapper.selectAllAdvertisement();
    }

    /**
     * 根据主键查询广告信息
     * @param advertisementId
     * @return
     */
    @Override
    public Advertise selectById(String advertisementId) {
        return advertisementMapper.selectById(advertisementId);
    }

    /**
     * 新增一条广告信息
     * @param advertise 封装的广告信息
     * @return
     */
    @Override
    public int addAdvertisement(Advertise advertise) {
        return advertisementMapper.addAdvertisement(advertise);
    }

    /**
     * 更新一条广告信息
     * @param advertise
     * @return
     */
    @Override
    public int updateAdvertisement(Advertise advertise) {
        return advertisementMapper.updateAdvertisement(advertise);
    }

    /**
     * 删除一条广告信息
     * @param advertisementId 要删除的广告id
     * @return
     */
    @Override
    public int deleteAdvertisement(String advertisementId) {
        return advertisementMapper.deleteAdvertisement(advertisementId);
    }


}
