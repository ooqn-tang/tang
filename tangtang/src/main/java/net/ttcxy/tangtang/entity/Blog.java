package net.ttcxy.tangtang.entity;

import lombok.Data;

/**
 * Blog模型类
 */
@Data
public class Blog {

    //博客id
    private String id;

    //标题
    private String title;

    //作者
    private String username;

    //用户ID
    private String userId;

    //时间
    private String createDate;

    //内容
    private String text;

    //描述
    private String summary;

    //blog 类型名
    private String className;

    //blog 类型ID
    private String classId;

    //状态ID
    private String stateId;

    //状态
    private String stateName;

    //阅读次数
    private Integer pageviewCount;

    //评论数
    private Integer commentCount;

    //点赞数
    private Integer praiseCount;


}
