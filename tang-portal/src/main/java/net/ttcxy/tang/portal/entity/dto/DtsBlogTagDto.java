package net.ttcxy.tang.portal.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtsBlogTagDto {

    private String blogTagId;

    // 标签名")
    private String tagName;

    // 描述")
    private String synopsis;

    // 创建时间")
    private Date createDate;

    // 博客数量")
    private Integer count;

}
