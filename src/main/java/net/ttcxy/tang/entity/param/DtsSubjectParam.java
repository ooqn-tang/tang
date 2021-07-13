package net.ttcxy.tang.entity.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DtsSubjectParam {

    @ApiModelProperty("专题id")
    private String blogSubjectId;

    @ApiModelProperty("专题名")
    private String subjectName;

    @ApiModelProperty("描述")
    private String synopsis;
}
