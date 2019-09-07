package com.jnnvc.vblog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BlogComment {

    private String id;

    private String userId;

    private String blogId;

    private int commentStatus;

    private String commentContent;

    private int commentNum;

    private String createTime;
}
