package net.ttcxy.tangtang.service;


import net.ttcxy.tangtang.entity.Advertise;

import java.util.List;

public interface AdvertisementService {

    /**
     * 查询全部广告
     * @return 所有广告的集合
     */
    List<Advertise> selectAllAdvertisement();

    /**
     * 根据广告id查询
     * @param advertisementId 要查询的广告id
     * @return 根据id查询的广告信息
     */
    Advertise selectById(String advertisementId);

    /**
     * 向数据库插入一条广告信息
     * @param advertise 封装的广告信息
     * @return
     */
    int addAdvertisement(Advertise advertise);

    /**
     * 更新一条广告信息
     * @param advertise 封装的广告信息
     * @return
     */
    int updateAdvertisement(Advertise advertise);

    /**
     * 删除一条广告信息
     * @param advertisementId 要删除的广告id
     * @return
     */
    int deleteAdvertisement(String advertisementId);

}
