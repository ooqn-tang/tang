package cn.ttcxy.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DtsViewDto {

    private String dataId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String title;

    private String nickname;

    private String username;

    private String headUrl;

    private String type;

}
