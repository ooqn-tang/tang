package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.Advertise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvertisementMapper {

    /**
     * 查询全部广告
     * @return 广告列表
     */
    List<Advertise> selectAllAdvertisement();

    /**
     * 根据广告id查询
     * @param advertisementId 广告ID
     * @return 广告
     */
    Advertise selectById(@Param("id") String advertisementId);

    /**
     * 更新广告
     * @param advertise 广告实例
     * @return 0/1
     */
    int updateAdvertisement(Advertise advertise);

    /**
     * 增加广告
     * @param advertise 广告实例
     * @return 0/1
     */
    int addAdvertisement(Advertise advertise);

    /**
     * 删除广告
     * @param advertisementId 广告ID
     * @return  0/1
     */
    int deleteAdvertisement(@Param("id") String advertisementId);
}
