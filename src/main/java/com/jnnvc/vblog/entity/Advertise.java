package com.jnnvc.vblog.entity;

import lombok.Data;

@Data
public class Advertise {

    //广告id
    private String id;

    //广告标题
    private String title;

    //广告url地址
    private String url;

    //广告创建时间
    private String createDate;

    //广告投放时间
    private Integer deliveryTime;

    //广告描述
    private String description;

}
