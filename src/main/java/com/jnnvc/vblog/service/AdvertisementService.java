package com.jnnvc.vblog.service;

import com.jnnvc.vblog.entity.Advertise;

import java.util.List;

public interface AdvertisementService {

    /**
     * 查询全部广告
     * @return 所有广告的集合
     */
    List<Advertise> selectAllAdvertisement();

    /**
     * 根据广告id查询
     * @return
     */
    Advertise selectById(String advertisementId);

}
