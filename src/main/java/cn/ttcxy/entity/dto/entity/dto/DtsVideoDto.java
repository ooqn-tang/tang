package cn.ttcxy.entity.dto.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtsVideoDto {

    private String videoId;

    private String title;

    private String describe;

    private String coverUrl;

    private String headUrl;

    private String authorId;

    private Date createDate;

    private String videoUrl;

    private String state;

    private String name;

    private String username;

    private String nickname;

    private String codeName;

    private Integer likeCount;

    private Integer coinCount;

    private Integer viewCount;

    private Integer commentCount;

    private DtsDataCount dataCount;

    private String grade;

}
