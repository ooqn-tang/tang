package com.jnnvc.vblog.mapper;

import com.jnnvc.vblog.entity.Advertise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdvertisementMapper {

    //查询全部广告
    List<Advertise> selectAllAdvertisement();

    //根据广告id查询
    Advertise selectById(@Param("id") String advertisementId);


    //更新广告

    //增加广告

    //删除广告

}
