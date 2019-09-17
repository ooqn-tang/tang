package net.ttcxy.tangtang.entity;

import lombok.Data;

import java.util.List;

/**
 * 微博
 */
@Data
public class Vibo {

    //String ID
    private String id;

    //作者
    private User user;

    //内容
    private String text;

    //图片 links
    private List<String> ImageLinks;

    //绑定Link
    private String link;

    //评论数
    private Integer commentCount;

    //点赞数
    private Integer praiseCount;

}
