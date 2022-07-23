package cn.ttcxy.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtsDynamicDto {

    private String dynamicId;

    private String authorId;

    private String text;

    private String url;

    private Date createTime;

    private String coverUrl;

    private String nickname;

    private String username;

    private static final long serialVersionUID = 1L;

}
