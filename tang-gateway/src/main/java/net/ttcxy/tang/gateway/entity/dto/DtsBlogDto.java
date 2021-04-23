package net.ttcxy.tang.gateway.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.ttcxy.tang.gateway.entity.model.DtsBlog;
import net.ttcxy.tang.gateway.entity.model.UtsAuthor;

import java.util.Date;

/**
 * Blog模型类
 * @author huanglei
 */
@Data
public class DtsBlogDto {

    private String blogId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "博客标题")
    private String title;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "大纲")
    private String synopsis;

    @ApiModelProperty(value = "博文文本")
    private String text;

}
