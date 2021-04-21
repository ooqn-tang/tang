package net.ttcxy.tang.gateway.entity.param;

import lombok.Data;

import java.util.Date;

/**
 * 博客参数
 * @author huanglei
 */
@Data
public class DtsBlogCommentParam {
    private String id;

    private String blogId;

    private Integer status;

    private String userId;

    private String content;

    private Date createDate;

}