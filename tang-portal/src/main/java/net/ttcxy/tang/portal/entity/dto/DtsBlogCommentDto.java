package net.ttcxy.tang.portal.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 评论
 * @author huanglei
 */
@Data
public class DtsBlogCommentDto {

    private static final long serialVersionUID = 1L;

    private String blogCommentId;

    @ApiModelProperty(value = "评论状态")
    private Integer status;

    @ApiModelProperty(value = "评论人")
    private String authorId;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "评论时间")
    private Date createDate;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;
}
