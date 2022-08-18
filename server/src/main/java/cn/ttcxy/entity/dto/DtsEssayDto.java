package cn.ttcxy.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtsEssayDto {

    private String essayId;

    private String authorId;

    private String text;

    private String url;

    private Date createTime;

    private String coverUrl;

    private String nickname;

    private String username;

}
