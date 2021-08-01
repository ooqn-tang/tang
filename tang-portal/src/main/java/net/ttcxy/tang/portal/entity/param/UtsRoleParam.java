package net.ttcxy.tang.portal.entity.param;

import lombok.Data;

import java.util.Date;

/**
 * @author huanglei
 */
@Data
public class UtsRoleParam {
    // id")
    private String id;

    // 中文名称")
    private String roleName;

    // 角色值，需要为字母，推荐为中文拼音")
    private String roleValue;

    // 创建时间")
    private Date createTime;

}
