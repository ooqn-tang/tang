package net.ttcxy.tang.entity.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author huanglei
 */
@Data
public class UtsResourceParam {

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "资源名")
    private String name;

    @ApiModelProperty(value = "资源所在节点,例,/为一级，/user为二级，/user/delete为三级")
    private String level;

    @ApiModelProperty(value = "M：目录，C：菜单 ，A : 接口 。")
    private String type;

    private Date createTime;
}
