package cn.ttcxy.entity.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
