package cn.ttcxy.entity.param;

import lombok.Data;

import java.util.Date;

@Data
public class VideoParam {

    private String videoId;

    private String title;

    private String describe;

    private String coverUrl;

    private String authorId;

    private Date createDate;

    private String videoUrl;

    private String classId;

}
