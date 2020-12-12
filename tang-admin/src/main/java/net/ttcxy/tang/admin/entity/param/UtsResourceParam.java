package net.ttcxy.tang.admin.entity.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.ttcxy.tang.code.Insert;
import net.ttcxy.tang.code.Update;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author huanglei
 */
@Data
@GroupSequence({Insert.class, Update.class})
public class UtsResourceParam {

    @NotNull(groups = {Update.class},message = "ID 不能为空")
    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    @ApiModelProperty(value = "路径")
    @NotNull(groups = {Insert.class, Update.class}, message = "路径不能为空")
    private String path;

    @ApiModelProperty(value = "资源名")
    @NotNull(message = "名称不能未空")
    @Size(min = 3,max = 15)
    private String name;

    @ApiModelProperty(value = "资源所在节点,例,/为一级，/user为二级，/user/delete为三级")
    private String level;

    @ApiModelProperty(value = "M：目录，C：菜单 ，A : 接口 。")
    @NotNull(message = "类型不能未空")
    @Pattern(groups = {Insert.class, Update.class}, regexp = "^[MCA]$",message = "type 参数为 M,C,A")
    private String type;

    private Date createTime;
}
