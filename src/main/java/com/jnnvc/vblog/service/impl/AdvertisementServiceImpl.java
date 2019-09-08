package com.jnnvc.vblog.service.impl;

import com.jnnvc.vblog.entity.Advertise;
import com.jnnvc.vblog.mapper.AdvertisementMapper;
import com.jnnvc.vblog.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementMapper advertisementMapper;

    @Override
    public List<Advertise> selectAllAdvertisement() {
        return advertisementMapper.selectAllAdvertisement();
    }

    @Override
    public Advertise selectById(String advertisementId) {
        return advertisementMapper.selectById(advertisementId);
    }


}
