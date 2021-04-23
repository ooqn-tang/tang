package net.ttcxy.tang.gateway.entity.param;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 博客参数
 * @author huanglei
 */
@Data
public class DtsBlogCommentParam {

    @ApiModelProperty("博客评论ID")
    private String blogCommentId;

    @ApiModelProperty("博客ID")
    @NotBlank(message = "评论不能为空")
    private String blogId;

    @ApiModelProperty("评论内容")
    @Length(min = 1,max = 250,message = "请正确输入内容")
    private String content;

}