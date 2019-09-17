package net.ttcxy.tangtang.mapper;

import net.ttcxy.tangtang.entity.Advertise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvertisementMapper {

    //查询全部广告
    List<Advertise> selectAllAdvertisement();

    //根据广告id查询
    Advertise selectById(@Param("id") String advertisementId);

    //更新广告
    int updateAdvertisement(Advertise advertise);

    //增加广告
    int addAdvertisement(Advertise advertise);

    //删除广告
    int deleteAdvertisement(@Param("id") String advertisementId);
}
