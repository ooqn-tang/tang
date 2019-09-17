package net.ttcxy.tangtang.entity.params;

import lombok.Data;

import java.util.Date;

@Data
public class CommentParam {

    private String id;

    private String userId;

    private String blogId;

    private int commentStatus;

    private String commentContent;

    private int commentNum;

    private String createTime;
}
