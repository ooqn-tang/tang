package net.ttcxy.tangtang.dao;

import net.ttcxy.tangtang.entity.AdvertiseDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvertisementDao {

    /**
     * 查询全部广告
     * @return 广告列表
     */
    List<AdvertiseDto> selectAllAdvertisement();

    /**
     * 根据广告id查询
     * @param advertisementId 广告ID
     * @return 广告
     */
    AdvertiseDto selectById(@Param("id") String advertisementId);

    /**
     * 更新广告
     * @param advertiseDto 广告实例
     * @return 0/1
     */
    int updateAdvertisement(AdvertiseDto advertiseDto);

    /**
     * 增加广告
     * @param advertiseDto 广告实例
     * @return 0/1
     */
    int addAdvertisement(AdvertiseDto advertiseDto);

    /**
     * 删除广告
     * @param advertisementId 广告ID
     * @return  0/1
     */
    int deleteAdvertisement(@Param("id") String advertisementId);
}
