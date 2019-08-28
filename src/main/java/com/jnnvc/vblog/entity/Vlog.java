package com.jnnvc.vblog.entity;

import lombok.Data;

import java.util.Map;

/**
 * 视频
 */
@Data
public class Vlog {
    //视频标题
    private String title;

    //视频id
    private String id;

    //视频作者
    private User user;

    //视频目录
    private Map<String,String> vlogs;

    //视频路径
    private String link;

    //文件状态
    private String status;

    //文件类型
    private  Integer fileYpe;


    //


    //

}
