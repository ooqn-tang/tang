package net.ttcxy.tang.portal.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * 评论
 * @author huanglei
 */
@Data
public class DtsBlogCommentDto {

    private static final long serialVersionUID = 1L;

    private String blogCommentId;

    // 评论状态
    private Integer status;

    // 评论人
    private String authorId;

    // 内容
    private String content;

    // 评论时间
    private Date createDate;

    // 用户名
    private String username;

    // 昵称
    private String nickname;
}
