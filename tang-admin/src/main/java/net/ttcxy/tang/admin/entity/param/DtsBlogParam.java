package net.ttcxy.tang.admin.entity.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author huanglei
 */
@Data
public class DtsBlogParam {

    private String id;

    @NotBlank(message = "请输入标题")
    private String title;

    private String userId;

    private Date createDate;

    private Date updateDate;

    private Integer stateId;

    @NotBlank(message = "请正确输入内容")
    private String text;

    @NotBlank(message = "请输入内容")
    private String markdown;
}
