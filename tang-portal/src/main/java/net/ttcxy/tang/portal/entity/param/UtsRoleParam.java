package net.ttcxy.tang.portal.entity.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author huanglei
 */
@Data
public class UtsRoleParam {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "中文名称")
    private String roleName;

    @ApiModelProperty(value = "角色值，需要为字母，推荐为中文拼音")
    private String roleValue;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
