package net.ttcxy.tangtang.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Blog模型类
 * @author huanglei
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BlogDto {

    /**
     * 博客id
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 时间
     */
    private String createDate;

    /**
     * 内容
     */
    private String text;

    /**
     * markdown
     */
    private String markdown;

    private String type;

    /**
     * 状态ID
     */
    private String stateId;

    /**
     * 状态
     */
    private String stateName;


    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 点赞数
     */
    private Integer praiseCount;

}
