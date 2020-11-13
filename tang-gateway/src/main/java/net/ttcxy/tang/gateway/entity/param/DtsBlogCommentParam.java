package net.ttcxy.tang.gateway.entity.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 博客参数
 * @author huanglei
 */
@Data
public class DtsBlogCommentParam {
    private String id;

    private String blogId;

    private Integer status;

    private String userId;

    @NotBlank(message = "评论不能为空")
    private String content;

    private Date createDate;

}