package cn.ttcxy.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtsCommentDto {

    private String commentId;

    private String dataId;

    private String parentCommentId;

    private String authorId;

    private String text;

    private Date createDate;

    private String type;

    private String nickname;

    private String username;

    private String commentCount;

    private String state;

    private String codeName;
}
