package net.ttcxy.tang.gateway.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class DtsBlogSubjectDto {

    private String blogSubjectId;

    @ApiModelProperty(value = "标题")
    private String subjectName;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    private String synopsis;

}
