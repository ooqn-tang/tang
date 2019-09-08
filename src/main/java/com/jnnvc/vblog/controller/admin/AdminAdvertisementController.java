package com.jnnvc.vblog.controller.admin;

import com.jnnvc.vblog.entity.Advertise;
import com.jnnvc.vblog.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//广告管理
@RequestMapping("adminAdv")
public class AdminAdvertisementController {

    @Autowired
    private AdvertisementService advertisementServiceImpl;

    //查询广告
    @RequestMapping("show")
    public List<Advertise> show(){
        return advertisementServiceImpl.selectAllAdvertisement();
    }

    //根据广告id查询
    @GetMapping("select/{id}")
    public Advertise selectById(@PathVariable("id") String advertisementId){
        return advertisementServiceImpl.selectById(advertisementId);
    }

    //更新广告

    //增加广告

    //删除广告

}
