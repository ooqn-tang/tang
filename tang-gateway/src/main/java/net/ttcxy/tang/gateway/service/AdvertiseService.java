package net.ttcxy.tang.gateway.service;


import net.ttcxy.tang.gateway.model.Advertise;

import java.util.List;

public interface AdvertiseService {

    /**
     * 查询全部广告
     * @return 所有广告的集合
     */
    List<Advertise> selectAllAdvertise();

    /**
     * 根据广告id查询
     * @param id 要查询的广告id
     * @return 根据id查询的广告信息
     */
    Advertise selectById(String id);

    /**
     * 向数据库插入一条广告信息
     * @param advertise 封装的广告信息
     * @return
     */
    int insertAdvertise(Advertise advertise);

    /**
     * 更新一条广告信息
     * @param advertise 封装的广告信息
     * @return
     */
    int updateAdvertise(Advertise advertise);

    /**
     * 删除一条广告信息
     * @param id 要删除的广告id
     * @return
     */
    int deleteAdvertise(String id);

}
