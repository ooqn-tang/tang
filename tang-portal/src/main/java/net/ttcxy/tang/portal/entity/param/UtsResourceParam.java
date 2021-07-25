package net.ttcxy.tang.portal.entity.param;

import lombok.Data;

import java.util.Date;

/**
 * @author huanglei
 */
@Data
public class UtsResourceParam {

    // ID")
    private String id;

    // 父ID")
    private String parentId;

    // 路径")
    private String path;

    // 资源名")
    private String name;

    // 资源所在节点,例,/为一级，/user为二级，/user/delete为三级")
    private String level;

    // M：目录，C：菜单 ，A : 接口 。")
    private String type;

    private Date createTime;
}
