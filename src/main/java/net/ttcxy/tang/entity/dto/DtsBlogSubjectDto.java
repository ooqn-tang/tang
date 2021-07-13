package net.ttcxy.tang.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.ttcxy.tang.entity.model.DtsBlog;

import java.util.Date;
import java.util.List;

@Data
public class DtsBlogSubjectDto {

    private String blogSubjectId;

    @ApiModelProperty(value = "专题名")
    private String subjectName;

    @ApiModelProperty(value = "描述")
    private String synopsis;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    private String authorId;

    private String username;

    private String nickname;

    @ApiModelProperty(value = "博客列表")
    private List<DtsBlog> blogList;
}
