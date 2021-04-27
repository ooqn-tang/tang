package net.ttcxy.tang.gateway.entity.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DtsTagParam {

    private String blogTagId;

    @ApiModelProperty(value = "标签名")
    private String tagName;

    @ApiModelProperty(value = "描述")
    private String synopsis;
}
