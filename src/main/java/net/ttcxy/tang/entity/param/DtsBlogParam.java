package net.ttcxy.tang.entity.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

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

    @ApiModelProperty(value = "专题ID")
    private String subjectId;

    @ApiModelProperty(value = "标签ID列表")
    @Size(max = 3, message = "标签数量不能超过3个")
    private List<String> tagIdList;
}
