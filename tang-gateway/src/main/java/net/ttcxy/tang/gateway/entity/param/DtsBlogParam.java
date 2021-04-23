package net.ttcxy.tang.gateway.entity.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author huanglei
 */
@Data
public class DtsBlogParam {

    private String blogId;

    @ApiModelProperty(value = "博客标题")
    @NotBlank
    @Length(min = 1, max = 30, message = "长度在1 ~ 30之间")
    private String title;

    @ApiModelProperty(value = "描述")
    @NotBlank
    @Length(min = 1, max = 150, message = "长度在1 ~ 150之间")
    private String synopsis;

    @ApiModelProperty(value = "博文文本")
    @NotBlank
    private String text;

    @ApiModelProperty(value = "markdown")
    @NotBlank
    private String markdown;
}
