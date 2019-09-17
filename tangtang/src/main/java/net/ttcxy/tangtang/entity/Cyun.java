package net.ttcxy.tangtang.entity;

import lombok.Data;

import java.util.List;

/**
 * 收藏
 */
@Data
public class Cyun {

    //所有的收藏人列表
    private List<User> cyunUsers ;

    //最新收藏时间
    private String dateTime;

    //link
    private String link;

    //标题
    private String title;

    //内容
    private String text;

    //评论数
    private Integer commentCount;

    //点赞数
    private Integer praiseCount;

}
