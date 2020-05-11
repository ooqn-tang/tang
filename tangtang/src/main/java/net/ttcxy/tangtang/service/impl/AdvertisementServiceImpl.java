package net.ttcxy.tangtang.service.impl;

import net.ttcxy.tangtang.entity.AdvertiseDto;
import net.ttcxy.tangtang.dao.AdvertisementDao;
import net.ttcxy.tangtang.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementDao advertisementDao;

    /**
     * 查询全部广告信息
     * @return
     */
    @Override
    public List<AdvertiseDto> selectAllAdvertisement() {
        return advertisementDao.selectAllAdvertisement();
    }

    /**
     * 根据主键查询广告信息
     * @param advertisementId
     * @return
     */
    @Override
    public AdvertiseDto selectById(String advertisementId) {
        return advertisementDao.selectById(advertisementId);
    }

    /**
     * 新增一条广告信息
     * @param advertiseDto 封装的广告信息
     * @return
     */
    @Override
    public int addAdvertisement(AdvertiseDto advertiseDto) {
        return advertisementDao.addAdvertisement(advertiseDto);
    }

    /**
     * 更新一条广告信息
     * @param advertiseDto
     * @return
     */
    @Override
    public int updateAdvertisement(AdvertiseDto advertiseDto) {
        return advertisementDao.updateAdvertisement(advertiseDto);
    }

    /**
     * 删除一条广告信息
     * @param advertisementId 要删除的广告id
     * @return
     */
    @Override
    public int deleteAdvertisement(String advertisementId) {
        return advertisementDao.deleteAdvertisement(advertisementId);
    }


}
