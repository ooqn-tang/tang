package net.ttcxy.tangtang.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author huanglei
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserRoleDto {

    static final long serialVersionUID = 1L;

    private String userId;

    private String roleId;

}
